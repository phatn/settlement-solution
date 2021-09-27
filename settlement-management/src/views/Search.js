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

import {createSettlement, searchByTradeId, resetResponseMessage} from 'actions/SettlementAction';
import { connect } from "react-redux";

const mapStateToProps = (store) => {
  return {searchSettmentStore: store.settlement}
}

class SearchSettlement extends Component {

  constructor(props) {
    super(props);
    this.state = {
      searchText: null,
      isSettlementLoaded: false
    }
  }

  componentWillMount() {
    this.props.dispatch(resetResponseMessage())
  }

  handleSearch = () => {
    this.props.dispatch(searchByTradeId(this.state.searchText))
  }

  handleCreateSettlement = () => {
    this.props.dispatch(createSettlement(this.state))
  }

  isResponseMessageAvailable = responseMessage => responseMessage != undefined 
      && responseMessage != null 
      && responseMessage.errorMessage != null
      && responseMessage.errorMessage != undefined
      && responseMessage.errorMessage !== '';

  onDismiss = () => {
    this.props.dispatch(resetResponseMessage())
  }

  handleInputChange = (e) => {
    const {name, value} = e.target;
    this.setState({[name] : value});
  }

  render() {

    const {
      settlement,
      isSettlementLoaded,
      tradeId,
      ssiCode,
      amount,
      currency,
      valueDate,
      searchResponseMessage
    } = this.props.searchSettmentStore;

    if(isSettlementLoaded && settlement && settlement.tradeId) {
      this.state.isSettlementLoaded = isSettlementLoaded;
    }

    return (
      <>
        <Container fluid>
          <Row>
              <Col md="8">
                <Alert color="danger" toggle={this.onDismiss} isOpen={this.isResponseMessageAvailable(searchResponseMessage)}>
                  <div>{this.isResponseMessageAvailable(searchResponseMessage) ? searchResponseMessage.errorMessage : ""}</div>
                </Alert>
              </Col>
          </Row>

          <Row>
            <Col md="8">
              <Card>
                
                <Card.Body>
                
                < Row>
                    <Col className="pr-1" md="9">
                      <Form.Group>
                      
                        <Form.Control name ="searchText" onChange={this.handleInputChange}
                          placeholder="Search..."
                          type="text" 
                        ></Form.Control>
                      </Form.Group>
                    </Col>
                    <Col className="pr-1" md="3">
                    <Form.Group>
                      
                      <Form.Control name ="btnSearch" onClick={this.handleSearch} 
                        disabled={this.state.searchText == null || this.state.searchText == undefined || this.state.searchText === ''}
                        placeholder="Search..."
                        type="button" value="Search" className="btn-fill pull-right btn btn-info"
                      ></Form.Control>
                    </Form.Group>
            
                    </Col>
                  </Row>
                  
                </Card.Body>
              </Card>
            </Col>
          </Row>
          {this.state.isSettlementLoaded ?
          <Row>
            <Col md="8">
              <Card>
                <Card.Header>
                  <Card.Title as="h4">Settlement Details</Card.Title>
                </Card.Header>
                <Card.Body>
                  <Form>
                    <Row>
                    
                      <Col className="pr-1" md="6">
                        <Form.Group>
                          <label>Trade ID</label>
                          <Form.Control name ="tradeId"
                            readOnly
                            type="text" value={settlement.tradeId}
                          ></Form.Control>
                        </Form.Group>
                      </Col>

                      <Col className="pr-1" md="6">
                        <Form.Group>
                          <label>Message Id</label>
                          <Form.Control name="messageId"
                            readOnly
                            type="text" value={settlement.messageId}
                          ></Form.Control>
                        </Form.Group>
                      </Col>
                    </Row>
                    <Row>
                      <Col className="pr-1" md="6">
                        <Form.Group>
                          <label>Amount</label>
                          <Form.Control name="amount"
                            readOnly
                            type="text" value={settlement.amount}
                          ></Form.Control>
                        </Form.Group>
                      </Col>
                      <Col className="pr-1" md="6">
                        <Form.Group>
                          <label>Value Date</label>
                          <Form.Control name="valueDate"
                            readOnly
                            type="text" value={settlement.valueDate}
                          ></Form.Control>
                        </Form.Group>
                      </Col>
                      
                    </Row>
                    <Row>
                      <Col className="pr-1" md="6">
                          <Form.Group>
                            <label>Currency</label>
                            <Form.Control name="currency"
                              readOnly
                              type="text" value={settlement.currency}
                            ></Form.Control>
                          </Form.Group>
                        </Col>
                        <Col className="pr-1" md="6">
                        <Form.Group>
                          <label>Supporting Information</label>
                          <Form.Control name="currency"
                            readOnly
                            type="text" value={settlement.supportingInformation}
                          ></Form.Control>
                        </Form.Group>
                      </Col>
                    </Row>

                    <Row>
                      <Col className="pr-1" md="6">
                          <Form.Group>
                            <label>Payer Account Number</label>
                            <Form.Control name="payerAccountNumber"
                              readOnly
                              type="text" value={settlement?.payerParty?.accountNumber}
                            ></Form.Control>
                          </Form.Group>
                        </Col>
                        <Col className="pr-1" md="6">
                        <Form.Group>
                          <label>Payer Account Bank</label>
                          <Form.Control name="payerAccountBank"
                            readOnly
                            type="text" value={settlement?.payerParty?.accountBank}
                          ></Form.Control>
                        </Form.Group>
                      </Col>
                    </Row>
                    <Row>
                      <Col className="pr-1" md="6">
                          <Form.Group>
                            <label>Receiver Account Number</label>
                            <Form.Control name="receiverAccountNumber"
                              readOnly
                              type="text" value={settlement?.receiverParty?.accountNumber}
                            ></Form.Control>
                          </Form.Group>
                        </Col>
                        <Col className="pr-1" md="6">
                        <Form.Group>
                          <label>Receiver Account Bank</label>
                          <Form.Control name="receiverAccountBank"
                            readOnly
                            type="text" value={settlement?.receiverParty?.accountBank}
                          ></Form.Control>
                        </Form.Group>
                      </Col>
                    </Row>
                    <div className="clearfix"></div>
                  </Form>
                </Card.Body>
              </Card>
            </Col>
          </Row>

          : <div></div>}
        </Container>
      </>
    );
  }
}

export default connect(mapStateToProps)(SearchSettlement);
