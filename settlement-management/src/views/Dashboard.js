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
  Col,
  NavLink
} from "react-bootstrap";

import { Link } from "react-router-dom";

class Dashboard extends Component {

  render() {

    return (
      <>
        <Container fluid>

          <Row>
            <Col md="8">
              <Card>
                <Card.Header>
                  <Card.Title as="h4">Quick Link</Card.Title>
                </Card.Header>
                <Card.Body>
                < Row>
                    <Col className="pr-1" md="6">
                    <ul className="nav flex-column">
                        <li className="nav-item"> 
                          <Link to="/admin/create">Create Settlement</Link>
                        </li>
                        <li className="nav-item">
                          <Link to="/admin/search">Search Settlement</Link>
                        </li>
                  </ul>
                    </Col>
                  </Row>
                  
                </Card.Body>
              </Card>
            </Col>
          </Row>
        </Container>
      </>
    );
  }
}

export default Dashboard;
