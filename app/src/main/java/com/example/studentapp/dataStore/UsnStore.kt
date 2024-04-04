package com.example.studentapp.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UsnStore(private val context: Context) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("usn storage")
        val USN_NUMBER = stringPreferencesKey("usn_number")
    }

    val getUsn: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[USN_NUMBER] ?: ""
        }

    suspend fun saveUsn(usn: String) {
        context.dataStore.edit { preferences ->
            preferences[USN_NUMBER] = usn
        }
    }
}