import React, {Component} from "react";

// react-bootstrap components
import {
  Badge,
  Button,
  Card,
  Form,
  Navbar,
  Nav,
  Container,
  Row,
  Col
} from "react-bootstrap";

import {Alert} from 'reactstrap';

import {createSettlement, resetResponseMessage, loadCurrencies, loadSSIReferences} from 'actions/SettlementAction';
import { connect } from "react-redux";

const mapStateToProps = (store) => {
  return {settmentStore: store.settlement}
}

class CreateSettlement extends Component {

  constructor(props) {
    super(props);
    this.state = {
      tradeId: null,
      ssiCode: null,
      amount: null,
      currency: null,
      valueDate: null,
      formErrors: {
        tradeIdErrorMsg: '',
        ssiCodeErrorMsg: '',
        amountErrorMsg: '',
        currencyErrorMsg: '',
        valueDateErrorMsg: ''
      },
      isFormError: true
    }
  }

  componentWillMount() {
    this.props.dispatch(resetResponseMessage())
    this.props.dispatch(loadCurrencies())
    this.props.dispatch(loadSSIReferences())
  }

  loadCurrencies 

  handleCreateSettlement = () => {
      this.props.dispatch(createSettlement(this.state))
  }

  isResponseMessageAvailable = responseMessage => responseMessage != undefined && responseMessage != null;

  onDismiss = () => {
    this.props.dispatch(resetResponseMessage())
  }
  
  handleInputChange = (e) => {

    const {name, value, title} = e.target;
    const isEmpty = value == null || value == undefined || value === ''
    let propName = name + 'ErrorMsg';
    let errorMsg = '';

    if(isEmpty) {
      errorMsg = title + ' is required!'
    }

    if(!isEmpty && name == 'amount' && value < 0) {
      errorMsg = title + ' must be positive!'
    }
    this.state.formErrors[propName] = errorMsg

    this.setState({[name] : value}, () => {
      const hasError = this.state.tradeId == null || this.state.tradeId == undefined || this.state.tradeId === '' ||
        this.state.ssiCode == null || this.state.ssiCode == undefined || this.state.ssiCode === '' ||
        this.state.amount == null || this.state.amount == undefined || this.state.amount === '' || this.state.amount < 0 ||
        this.state.currency == null || this.state.currency == undefined || this.state.currency === '' || this.state.currency === 'SELECT_CURRENCY' ||
        this.state.valueDate == null || this.state.valueDate == undefined || this.state.valueDate === ''
      this.setState({isFormError: hasError})
    });

  }



  alertType = (responseMessage) => {
    if(responseMessage != undefined && responseMessage != null && responseMessage.status === 'error') {
      return "danger";
    }

    return "success";
  }

  alertMessage = (responseMessage) => {
    if(responseMessage != undefined && responseMessage != null) {
      return responseMessage.message;
    }

    return "";
  }

  render() {

    const {
      currencies,
      ssiReferences,
      isCurrenciesLoaded,
      isSSIReferencesLoaded,
      responseMessage
    } = this.props.settmentStore;

    return (
      <>
        <Container fluid>
        < Row>
            <Col md="8">
              <Alert color={this.alertType(responseMessage)} toggle={this.onDismiss} isOpen={this.isResponseMessageAvailable(responseMessage)}>
                <div>{this.isResponseMessageAvailable(responseMessage) ? responseMessage.message : ""}</div>
              </Alert>
            </Col>
          </Row>
          <Row>
            <Col md="8">
              <Card>
                <Card.Header>
                  <Card.Title as="h4">Create A Settlement</Card.Title>
                </Card.Header>
                <Card.Body>
                  <Form>
                    <Row>
                    
                      <Col className="pr-1" md="6">
                        <Form.Group>
                          <label>Trade ID</label>
                          <Form.Control name ="tradeId" onChange={this.handleInputChange}
                            placeholder="Trade ID" title="Trade ID"
                            type="text" 
                          ></Form.Control>
                          <span style={{'color': '#f86c6b'}}>{this.state.formErrors.tradeIdErrorMsg}</span>
                        </Form.Group>
                      </Col>
                      <Col className="pr-1" md="6">
                        <Form.Group>
                          <label>
                            SSI Code
                          </label>
                          {isSSIReferencesLoaded ? <Form.Control title="SSI Code" name="ssiCode" onChange={this.handleInputChange}
                            as="select">
                              <option key="SELECT_SSI_CODE" value="SELECT_SSI_CODE">Select SSI Code</option>
                              {ssiReferences.map((ssiReference) => <option key={ssiReference.ssicode} value={ssiReference.ssicode}>{ssiReference.ssicode}</option>)}
                          </Form.Control> : 
                            <Form.Control title="SSI Code" name="ssiCode" onChange={this.handleInputChange}
                            as="select">
                               <option key="SELECT_SSI_CODE" value="SELECT_SSI_CODE">Select SSI Code</option>
                            </Form.Control>
                          }
                          </Form.Group>
                      </Col>
                    </Row>
                    <Row>
                      <Col className="pr-1" md="6">
                        <Form.Group>
                          <label>Amount</label>
                          <Form.Control name="amount" onChange={this.handleInputChange}
                            placeholder="Amount" title="Amount"
                            type="number" 
                          ></Form.Control>
                          <span style={{'color': '#f86c6b'}}>{this.state.formErrors.amountErrorMsg}</span>
                        </Form.Group>
                      </Col>
                      <Col className="pr-1" md="6">
                        <Form.Group>
                          <label>Currency</label>
                          {isCurrenciesLoaded ? <Form.Control title="Currency" name="currency" placeholder="currency" onChange={this.handleInputChange}
                            as="select">
                              <option key="SELECT_CURRENCY" value="SELECT_CURRENCY">Select Currency</option>
                              {currencies.map((currency) => <option key={currency.code} value={currency.code}>{currency.code}</option>)}
                          </Form.Control> : 
                            <Form.Control name="currency" title="Currency" onChange={this.handleInputChange}
                            as="select">
                              <option key="SELECT_CURRENCY" value="SELECT_CURRENCY">Select Currency</option>
                            </Form.Control>
                          }

                          
                        </Form.Group>
                      </Col>
                    </Row>
                    <Row>
                      <Col className="pr-1" md="6">
                        <Form.Group>
                          <label>Value Date</label>
                          <Form.Control name="valueDate" onChange={this.handleInputChange} title="Value Date"
                            type="date"
                          ></Form.Control>
                          <span style={{'color': '#f86c6b'}}>{this.state.formErrors.valueDateErrorMsg}</span>
                        </Form.Group>
                      </Col>
                      
                    </Row>
                    <Button onClick={this.handleCreateSettlement}
                      className="btn-fill pull-right"
                      type="button"
                      variant="info"
                      disabled={this.state.isFormError}
                    >
                      Create
                    </Button>
                    
                    <div className="clearfix"></div>
                  </Form>
                </Card.Body>
              </Card>
            </Col>
          </Row>
        </Container>
      </>
    );
  }
}

export default connect(mapStateToProps)(CreateSettlement);
