import React from "react";
import { Row, Col, Button, Table, Form, Tab } from 'react-bootstrap'
import OlympicsAxios from "../../apis/OlympicsAxios";
import { withParams, withNavigation } from '../../routeconf';

class Entry extends React.Component {

    constructor(props) {
        super(props)

        let entry = {

            discipline: ""

        }

        this.state = { entry: entry }
    }

    async create(e) {
        e.preventDefault()
        var entryDto = {
            "id": 1,
            "discipline": this.state.entry.discipline,
            "competitorId": 1,
            "dateOfEntry": "",
            "nameAndSurnameOfCompetitor": ""
        }


        try {
            let response = await OlympicsAxios.post("/entries", entryDto);
            alert("Uspesno prijavljen")
            this.props.navigate("/competitors");
        } catch (error) {
            alert("Ne moze se sacuvati takmicar")
        }
    }

    valueInputChanged(event) {
        let input = event.target;

        let name = input.name;
        let value = input.value;

        let entry = this.state.entry;
        entry[name] = value;

        this.setState({ entry: entry });
    }

    render() {
        return (
            <>
                <Row>
                    <Col></Col>
                    <Col xs="12" sm="10" md="8">
                        <h1>Prijava</h1>

                        <Form>
                            <Form.Group>
                                <Form.Label>Disciplina</Form.Label>
                                <Form.Control
                                    id="discipline" name="discipline" onChange={(event) => this.valueInputChanged(event)} /> <br />
                            </Form.Group>

                            <Button onClick={(e) => { this.create(e); }}>Prijavi se</Button>
                        </Form>
                    </Col>
                    <Col></Col>
                </Row>
            </>
        )
    }


}

export default withNavigation(Entry);