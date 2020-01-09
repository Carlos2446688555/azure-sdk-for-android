package com.azure.android.core.provider.implementation;

import android.content.Context;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

import com.azure.android.core.provider.LocaleInformationProvider;

/**
 * Provider that contains system locale information extracted using a {@link Configuration} and a {@link Context}
 * object. The former can be obtained by calling {@code Resources.getSystem().getConfiguration()}.
 */
public class AndroidLocaleInformationProvider implements LocaleInformationProvider {
    private final Configuration configuration;
    private String language;
    private String systemRegion;

    public AndroidLocaleInformationProvider(@NonNull Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public String getDefaultSystemLanguage() {
        if (language == null) {
            // Using this instead of Configuration.getLocales() because it's not supported in anything less than Android L24
            language = configuration.locale.getLanguage();
        }

        return language;
    }

    @Override
    public String getSystemRegion() {
        if (systemRegion == null) {
            // Using this instead of Configuration.getLocales() because it's not supported in anything less than Android L24
            systemRegion = configuration.locale.getCountry();
        }

        return systemRegion;
    }
}