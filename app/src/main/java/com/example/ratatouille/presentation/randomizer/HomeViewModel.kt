package com.example.ratatouille.presentation.randomizer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ratatouille.domain.use_cases.GetSettingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomizerViewmodel @Inject constructor(
    private val settingsUseCase: GetSettingsUseCase,
) : ViewModel() {

    private val _homeState = MutableStateFlow(RandomizerState())
    val homeState: StateFlow<RandomizerState> =
        _homeState.asStateFlow()

    private val _currentMode = MutableStateFlow(1)
    val currentMode: StateFlow<Int> = _currentMode.asStateFlow()

    fun getCurrentMode() {
        viewModelScope.launch {
            settingsUseCase.getUiMode().collectLatest {
                _currentMode.emit(it)
            }
        }
    }


}
