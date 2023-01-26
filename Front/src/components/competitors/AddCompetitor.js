import React from 'react';
import { Row, Col, Form, Button } from "react-bootstrap";
import OlympicsAxios from '../../apis/OlympicsAxios';
import { withParams, withNavigation } from '../../routeconf';

class AddCompetitor extends React.Component {

    constructor(props) {
        super(props)

        let competitor = {
            nameAndSurname: "",
            numOfMedals: 0,
            dateOfBirth: "",
            countryId: 0,
            nameOfCountry: ""
        }

        this.state = { competitor: competitor, countries: [] }
    }

    componentDidMount() {
        this.getCountries()
    }

    async getCountries() {
        try {
            let result = await OlympicsAxios.get("/countries")
            let countries = result.data
            this.setState({ countries: countries })
            console.log("ucitavanje drzava")
        } catch (error) {
            console.log(error)
        }
    }

    async create(e) {
        e.preventDefault()

        try {
            let competitor = this.state.competitor
            let competitorDTO = {
                nameAndSurname: competitor.nameAndSurname,
                numOfMedals: competitor.numOfMedals,
                dateOfBirth: competitor.dateOfBirth,
                countryId: competitor.countryId,
                nameOfCountry: competitor.nameOfCountry
            }

            let response = await OlympicsAxios.post("/competitors", competitorDTO)
            this.props.navigate("/competitors")
        } catch (error) {
            alert("Ne moze se sacuvati takmicar")
        }
    }

    valueInputChanged(e) {
        let input = e.target;

        let name = input.name;
        let value = input.value;

        let competitor = this.state.competitor;
        competitor[name] = value;

        this.setState({ competitor: competitor });
    }

    countrySelectionChanged(e) {
        let countryId = e.target.value
        let country = this.state.countries.find((country) => country.id == countryId)

        let competitor = this.state.competitor
        competitor.countryId = country.id
        competitor.nameOfCountry = country.name

        this.setState({ competitor: competitor })
    }

    render() {
        return (
            <>
                <Row>
                    <Col></Col>
                    <Col xs="12" sm="10" md="8">
                        <h1>Dodaj takmicara</h1>

                        <Form>
                            <Form.Group>
                                <Form.Label>Ime i prezime</Form.Label>
                                <Form.Control
                                    id="nameAndSurname" name="nameAndSurname" onChange={(e) => this.valueInputChanged(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label>Broj osvojenih medalja</Form.Label>
                                <Form.Control type="number" id="numOfMedals" name="numOfMedals" onChange={(e) => this.valueInputChanged(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label>Datum rodjenja</Form.Label>
                                <Form.Control id="dateOfBirth" name="dateOfBirth" onChange={(e) => this.valueInputChanged(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label>Drzava</Form.Label>
                                <Form.Select name="country" onChange={event => this.countrySelectionChanged(event)}>
                                    <option></option>
                                    {
                                        this.state.countries.map((country) => {
                                            return (
                                                <option key={country.id} value={country.id}>{country.name}</option>
                                            )
                                        })
                                    }
                                </Form.Select><br />
                            </Form.Group>

                            <Button onClick={(event) => { this.create(event); }}>Add</Button>
                        </Form>
                    </Col>
                    <Col></Col>
                </Row>
            </>
        )
    }

}

export default withNavigation(AddCompetitor);