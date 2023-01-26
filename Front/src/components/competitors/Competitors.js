import React from "react";
import { Row, Col, Button, Table, Form } from 'react-bootstrap'
import OlympicsAxios from "../../apis/OlympicsAxios";
import { withParams, withNavigation } from '../../routeconf';
import './../../index.css';


class Competitors extends React.Component {

  constructor(props) {
    super(props)

    this.pageNo = 0;
    this.totalPages = 0;

    const search = {
      countryId: "",
      numOfMedalsFrom: "",
      numOfMedalsTo: ""
    }

    this.state = {
      competitors: [],
      countries: [],
      search: search,
      showing: false
    }

  }

  componentDidMount() {
    this.getCompetitors(0)
    this.getCountries()
  }

  async getCompetitors(newPageNo) {

    let config = {
      params: {
        countryId: this.state.search.countryId,
        numOfMedalsFrom: this.state.search.numOfMedalsFrom,
        numOfMedalsTo: this.state.search.numOfMedalsTo,
        pageNo: newPageNo
      }
    }

    try {
      let result = await OlympicsAxios.get("/competitors", config)
      this.pageNo = newPageNo
      this.totalPages = result.headers["total-pages"]
      this.setState({
        competitors: result.data
      })
    } catch (error) {
      console.log(error)

    }
  }

  getCountries() {
    OlympicsAxios.get("/countries")
      .then((res) => {
        this.setState({ countries: res.data })
      })
      .catch((error) => {
        console.log(error)
      })
  }

  goToAdd() {
    this.props.navigate("/competitors/add")
  }

  goToEdit(id) {
    this.props.navigate("/competitors/edit/" + id)
  }

  goToEntry(id) {
    this.props.navigate("/entry/newentry/" + id)
  }

  deleteFromState(competitorId) {
    var competitors = this.state.competitors
    competitors.forEach((element, index) => {
      if (element.id === competitorId) {
        competitors.splice(index, 1)
        this.setState({ competitors: competitors })
      }
    })
  }

  goToDelete(competitorId) {
    OlympicsAxios.delete("/competitors/" + competitorId)
      .then(res => {
        console.log(res)
        alert("Uspesno brisanje takmicara")
        this.deleteFromState(competitorId)
      })
      .catch(error => {
        console.log(error)
        window.location.reload()
      })
  }

  onInputChange(event) {
    const name = event.target.name;
    const value = event.target.value

    let search = this.state.search;
    search[name] = value;

    this.setState({ search })
  }

  goToStatistic() {
    this.props.navigate("/competitors/statistic")
  }

  renderSearchForm() {
    return (
      <>
        <Form style={{ width: "100%" }}>
          <Row><Col>
            <Form.Group>
              <Form.Label>Broj medalja od</Form.Label>
              <Form.Control
                name="numOfMedalsFrom"
                as="input"
                type="number"
                onChange={(e) => this.onInputChange(e)}>
              </Form.Control>
            </Form.Group>
          </Col>
          </Row>
          <Row><Col>
            <Form.Group>
              <Form.Label>Broj medalja do</Form.Label>
              <Form.Control
                name="numOfMedalsTo"
                as="input"
                type="number"
                onChange={(e) => this.onInputChange(e)}>
              </Form.Control>
            </Form.Group>
          </Col>
          </Row>
          <Row>
            <Col>
              <Form.Group>
                <Form.Label>Drzava</Form.Label>
                <Form.Select
                  name="countryId"
                  onChange={(e) => this.onInputChange(e)}>
                  <option value=""></option>
                  {this.state.countries.map((country) => {
                    return (
                      <option value={country.id}>{country.name}</option>
                    );
                  })}
                </Form.Select>
              </Form.Group>
            </Col>
          </Row>
        </Form>
        <Row><Col>
          <Button className="mt-3" onClick={() => this.getCompetitors()}>Search</Button>
          <br />
          <br />
        </Col>
        </Row>
      </>
    )
  }

  render() {
    return (
      <Col>
        <Row>Takmicari</Row>
        <label>
          <input type="checkbox" onChange={() => this.setState({ showing: !this.state.showing })} />
          Search
        </label>
        <div>
          <Row hidden={this.state.showing}>
            {this.renderSearchForm()}
          </Row>
        </div>
        <Row><Col>
          <Button onClick={() => this.goToAdd()}>Add</Button>
          <Button onClick={() => this.goToStatistic()}>Statistika</Button>
        </Col></Row>

        <Row><Col>

        </Col></Row>
        <Row><Col>

          <Table style={{ marginTop: 5 }}>
            <thead>
              <tr>
                <th>Ime i prezime</th>
                <th>Broj osvojenih medalja</th>
                <th>Datum rodjenja</th>
                <th>Drzava</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              {this.state.competitors.map((competitor) => {
                return (
                  <tr key={competitor.id}>
                    <td>{competitor.nameAndSurname}</td>
                    <td>{competitor.numOfMedals}</td>
                    <td>{competitor.dateOfBirth}</td>
                    <td>{competitor.nameOfCountry}</td>
                    <td><Button variant="warning" onClick={() => this.goToEdit(competitor.id)}>Edit</Button></td>
                    <td><Button variant="danger" onClick={() => this.goToDelete(competitor.id)}>Delete</Button></td>
                    {window.localStorage['role'] == 'KORISNIK' ?
                      <td><Button variant="info" onClick={() => this.goToEntry(competitor.id)}>Prijava</Button></td> : null}
                  </tr>
                );
              })}
            </tbody>
          </Table>
          <Button disabled={this.pageNo === 0} onClick={() => this.getCompetitors(this.pageNo - 1)} className="mr-3">Prev</Button>
          <Button disabled={this.pageNo == this.totalPages - 1} onClick={() => this.getCompetitors(this.pageNo + 1)} className="mr-3">Next</Button>
        </Col></Row>
      </Col>
    )
  }

}

export default withNavigation(withParams(Competitors))