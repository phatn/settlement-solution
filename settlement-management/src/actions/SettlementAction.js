import settlementApi from "apis/SettlementAPI";

export const CREATE_SETTLEMENT = 'CREATE_SETTLEMENT';
export const SEARCH_BY_TRADE_ID = 'SEARCH_BY_TRADE_ID';
export const RESET_RESPONSE_MESSAGE = 'RESET_RESPONSE_MESSAGE';
export const LOAD_CURRENCIES = 'LOAD_CURRENCIES';
export const LOAD_SSI_REFERENCES = 'LOAD_SSI_REFERENCES';

export function createSettlement(tradeRequest) {

    return (dispatch) => {
        
        settlementApi.createSettlement(tradeRequest)
            .then(response => {
                dispatch({type: CREATE_SETTLEMENT, payload: response.data})
            })
    }
}

export function searchByTradeId(tradeId) {
    return (dispatch) => {
        
        settlementApi.searchByTradeId(tradeId)
            .then(response => {
                dispatch({type: SEARCH_BY_TRADE_ID, data: response.data})
            })
    }
}

export function resetResponseMessage() {
    return (dispatch) => {
        dispatch({type: RESET_RESPONSE_MESSAGE})
    } 
}

export function loadCurrencies() {
    return (dispatch) => {
        
        settlementApi.loadCurrencies()
            .then(response => {
                dispatch({type: LOAD_CURRENCIES, data: response.data})
            })
    }
}

export function loadSSIReferences() {
    return (dispatch) => {
        
        settlementApi.loadSSIReferences()
            .then(response => {
                dispatch({type: LOAD_SSI_REFERENCES, data: response.data})
            })
    }
}