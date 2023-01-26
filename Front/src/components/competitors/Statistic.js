import React from "react";
import { Row, Col, Button, Table, Form, Tab } from 'react-bootstrap'
import OlympicsAxios from "../../apis/OlympicsAxios";
import {withParams ,withNavigation} from '../../routeconf';

class Statistic extends React.Component{

    constructor(props){
        super(props)

        this.pageNo = 0;
        this.totalPages = 0;

        this.state = { competitors: []}
    }

    async getCompetitors(newPageNo){

             var conf = {
            params: {
                pageNo: newPageNo
            }
        }

        try {
            let result = await OlympicsAxios.get("/competitors", conf)
            this.pageNo= newPageNo
            this.totalPages=result.headers["total-pages"]
            this.setState({
                competitors: result.data
            })
        } catch (error) {
            console.log(error)
        }
    }

    componentDidMount(){
        this.getCompetitors(0)
    }

    renderStatistic(){
        return this.state.competitors.map((competitor)=>{
            return(
                        <tr key={competitor.id}>
                            <td>{competitor.nameOfCountry}</td>
                            <td>{competitor.numOfMedals}</td>
                        </tr> 
                )
            })

    }

    render(){
        return(
            <Col>
            <Row><h1>Statistika</h1></Row>
            <Table style={{marginTop: 5}}>
                <thead>
                    <tr>
                        <th>Drzava</th>
                        <th>Broj osvojenih medalja</th>
                    </tr>
                </thead>
                <tbody>
                    {this.renderStatistic()}
                </tbody>
            </Table>
            <Button disabled={this.pageNo===0}
                        onClick={()=>this.getCompetitors(this.pageNo-1)}
                        className="mr-3">Prev</Button>
                <Button disabled={this.pageNo==this.totalPages-1}
                        onClick={()=>this.getCompetitors(this.pageNo+1)}
                        className="mr-3">Next</Button>
            </Col>
            )
        }
    }



export default withParams(withNavigation(Statistic))