import React from "react";
import OlympicsAxios from "../../apis/OlympicsAxios";
import { Button, Col, Form, Row } from 'react-bootstrap';
import { withNavigation, withParams } from '../../routeconf'

class EditCompetitor extends React.Component {

    state = {
        competitorId: -1,
        competitorNameAndSurname: "",
        competitorNumOfMedals: 0,
        competitorDateOfBirth: "",
        competitorCountryId: -1,
        competitorNameOfCountry: "",
        countries: []
    }

    componentDidMount() {
        var id = this.props.params.id
        this.getCountries()
        this.getCompetitorById(id)
    }

    async getCountries() {
        try {
            let result = await OlympicsAxios.get("/countries")
            let countries = result.data
            this.setState({ countries: countries })
            console.log("test1")
        } catch (error) {
            console.log(error)
            alert("Ne mogu se naci drzave")
        }
    }

    getCompetitorById(competitorId) {
        OlympicsAxios.get("/competitors/" + competitorId)
            .then(res => {
                console.log(res)
                this.setState({
                    competitorId: res.data.id,
                    competitorNameAndSurname: res.data.nameAndSurname,
                    competitorNumOfMedals: res.data.numOfMedals,
                    competitorDateOfBirth: res.data.dateOfBirth,
                    competitorCountryId: res.data.countryId,
                    competitorNameOfCountry: res.data.nameOfCountry
                })
            })
            .catch(error => {
                console.log(error)
            })
    }

    edit(competitorId) {
        var params = {
            "id": this.state.competitorId,
            "nameAndSurname": this.state.competitorNameAndSurname,
            "numOfMedals": this.state.competitorNumOfMedals,
            "dateOfBirth": this.state.competitorDateOfBirth,
            "countryId": this.state.competitorCountryId,
            "nameOfCountry": this.state.competitorNameOfCountry
        }

        OlympicsAxios.put("/competitors/" + this.state.competitorId, params)
            .then(res => {
                console.log(res)
                this.props.navigate("/competitors")
            })
            .catch(error => {
                console.log(error)
            })
    }

    onNameAndSurnameChange(e) {
        console.log(e.target.value)
        this.setState({ competitorNameAndSurname: e.target.value })
    }

    onNumOfMedalsChange(e) {
        console.log(e.target.value)
        this.setState({ competitorNumOfMedals: e.target.value })
    }

    onDateOfBirthChange(e) {
        console.log(e.target.value)
        this.setState({ competitorDateOfBirth: e.target.value })
    }

    countrySelectionChanged(e) {
        let countryId = e.target.value
        let country = this.state.countries.find((country) => country.id == countryId)

        this.state.competitorCountryId = country.id
        this.state.competitorNameOfCountry = country.name
    }

    render() {
        return (
            <>
                <Row>
                    <Col></Col>
                    <Col xs="12" sm="10" md="8">
                        <h1>Izmena takmicara</h1>
                        <Form>
                            <Form.Group>
                                <Form.Label htmlFor="nameAndSurname">Ime i prezime</Form.Label>
                                <Form.Control id="nameAndSurname" name="nameAndSurname" value={this.state.competitorNameAndSurname} onChange={(e) => this.onNameAndSurnameChange(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label htmlFor="numOfMedals">Broj osvojenih medalja</Form.Label>
                                <Form.Control id="numOfMedals" name="numOfMedals" type="number" value={this.state.competitorNumOfMedals} onChange={(e) => this.onNumOfMedalsChange(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label htmlFor="dateOfBirth">Datum rodjenja</Form.Label>
                                <Form.Control id="dateOfBirth" name="dateOfBirth" value={this.state.competitorDateOfBirth} onChange={(e) => this.onDateOfBirthChange(e)} /> <br />
                            </Form.Group>

                            <Form.Group>
                                <Form.Label htmlFor="countryId">Drzava</Form.Label>
                                <Form.Control as="select" id="countryId" onChange={event => this.countrySelectionChanged(event)}>
                                    <option>{this.state.competitorNameOfCountry}</option>
                                    {
                                        this.state.countries.map((country) => {
                                            return (
                                                <option key={country.id} value={country.id}>{country.name}</option>
                                            )
                                        })
                                    }
                                </Form.Control><br />
                            </Form.Group>
                            <Button onClick={() => this.edit(this.state.competitorId)}>Edit</Button>
                        </Form>
                    </Col>
                    <Col></Col>
                </Row>
            </>
        )
    }



}

export default withParams(withNavigation(EditCompetitor))