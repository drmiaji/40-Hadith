package com.drmiaji.fortyahadith.utils

import android.os.Bundle
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import com.drmiaji.fortyahadith.R

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        preferenceManager.sharedPreferencesName = ThemeUtils.PREF_NAME
        setPreferencesFromResource(R.xml.preferences, rootKey)

        findPreference<ListPreference>(ThemeUtils.KEY_THEME_MODE)?.apply {
            value = ThemeUtils.getCurrentThemeMode(requireContext())
            summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()
            setOnPreferenceChangeListener { _, newValue ->
                ThemeUtils.saveThemeModeWithoutRestart(requireActivity(), newValue as String)
                true
            }
        }
    }
}
