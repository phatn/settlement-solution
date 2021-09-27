import {combineReducers} from 'redux';
import settlementReducer from 'reducers/SettlementReducer';

const rootReducer = combineReducers({
    settlement: settlementReducer
})

export default rootReducer;

