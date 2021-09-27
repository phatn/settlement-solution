import { CREATE_SETTLEMENT, SEARCH_BY_TRADE_ID, RESET_RESPONSE_MESSAGE, LOAD_CURRENCIES, LOAD_SSI_REFERENCES } from "actions/SettlementAction";

const defaultState = {
    isSettlementLoaded: false,
    isSettlementCreated: false,
    isCurrenciesLoaded: false,
    isSSIReferencesLoaded: false,
    settlement: {},
    currencies: [],
    ssiReferences: []
}

const settlementReducer = (state = defaultState, action) => {
    switch(action.type) {
        case CREATE_SETTLEMENT:
            return {...state, responseMessage: action.payload}
        case SEARCH_BY_TRADE_ID:
            return {...state, settlement: action.data, isSettlementLoaded: true, searchResponseMessage: action.data}
        case RESET_RESPONSE_MESSAGE:
            return {...state, responseMessage: null, searchResponseMessage: null}
        case LOAD_CURRENCIES:
            return {...state, currencies: action.data, isCurrenciesLoaded: true}
        case LOAD_SSI_REFERENCES:
            return {...state, ssiReferences: action.data, isSSIReferencesLoaded: true}
        default:
            return state
    }
}

export default settlementReducer;