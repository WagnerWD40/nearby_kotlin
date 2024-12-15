package com.example.nearby.ui.screen.market_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nearby.core.network.RemoteDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MarketDetailsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MarketDetailsUiState())
    val uiState: StateFlow<MarketDetailsUiState> = _uiState.asStateFlow()

    fun onEvent(event: MarketDetailsUiEvent) {

        when(event) {
            is MarketDetailsUiEvent.OnFetchCoupon -> fetchCoupon(qrCodeContent = event.qrCodeContent)
            is MarketDetailsUiEvent.OnFetchRules -> fetchRules(marketId = event.marketId)
            MarketDetailsUiEvent.OnResetCoupon -> resetCoupon()
        }
    }

    private fun fetchCoupon(qrCodeContent: String) {
        viewModelScope.launch {
            RemoteDataSource.patchCoupon(marketId = qrCodeContent)
                .onSuccess { coupon ->
                    _uiState.update { currentState ->
                        currentState.copy(coupon = coupon.coupon)
                    }
                }
                .onFailure {
                    _uiState.update { currentState ->
                        currentState.copy(coupon = "")
                    }
                }
        }
    }

    private fun fetchRules(marketId: String) {
        viewModelScope.launch {
            RemoteDataSource.getDetails(marketId = marketId)
                .onSuccess { details ->
                    _uiState.update { currentState ->
                        currentState.copy(rules = details.rules)
                    }
                }
                .onFailure {
                    _uiState.update { currentState ->
                        currentState.copy(rules = emptyList())
                    }
                }
        }
    }

    private fun resetCoupon() {
        _uiState.update { currentState ->
            currentState.copy(coupon = null)
        }
    }
}