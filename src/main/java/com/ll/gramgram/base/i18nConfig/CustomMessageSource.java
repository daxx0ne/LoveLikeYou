package com.ll.gramgram.base.i18nConfig;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CustomMessageSource extends ResourceBundleMessageSource {
    private static final Pattern VARIABLE_PATTERN = Pattern.compile("\\$\\[\\[(.+?)\\]\\]");

    @Override
    protected String resolveCodeWithoutArguments(String code, Locale locale) {
        if (!code.startsWith("c.")) return super.resolveCodeWithoutArguments(code, locale);

        return replaceVariablesToString(super.resolveCodeWithoutArguments(code, locale), locale);
    }

    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        if (!code.startsWith("c.")) return super.resolveCode(code, locale);

        return replaceVariables(super.resolveCode(code, locale), locale);
    }

    public String replaceVariablesToString(String code, Locale locale) {
        StringBuffer result = new StringBuffer();
        Matcher matcher = VARIABLE_PATTERN.matcher(code);

        while (matcher.find()) {
            String variable = matcher.group(1);
            String replacement = getMessage(variable, null, locale);
            matcher.appendReplacement(result, replacement);
        }
        matcher.appendTail(result);

        return result.toString();
    }

    private MessageFormat replaceVariables(MessageFormat messageFormat, Locale locale) {
        String message = messageFormat.toPattern();

        return new MessageFormat(replaceVariablesToString(message, locale), locale);
    }
}