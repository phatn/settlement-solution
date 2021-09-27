import {restRequest} from "./RestRequest"; 

let settlementApi = {
    createSettlement: createSettlement,
    searchByTradeId: searchByTradeId,
    loadCurrencies: loadCurrencies,
    loadSSIReferences: loadSSIReferences
}

function createSettlement(tradeRequest) {
    return restRequest.post(process.env.REACT_APP_API_SETTLEMENT_HOSTNAME + "/api/settlement", tradeRequest)
}

function searchByTradeId(tradeId) {
    return restRequest.get(process.env.REACT_APP_API_SETTLEMENT_HOSTNAME + "/api/settlement/" + tradeId)
}

function loadCurrencies() {

    return restRequest.get(process.env.REACT_APP_API_SETTLEMENT_HOSTNAME + "/api/currency")
}

function loadSSIReferences() {
    return restRequest.get(process.env.REACT_APP_API_SETTLEMENT_HOSTNAME + "/api/ssiReference")
}

export default settlementApi;