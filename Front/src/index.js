import React from "react";
import { createRoot } from "react-dom/client";
import { Route, Link, HashRouter as Router, Routes, Navigate } from 'react-router-dom';
import { Navbar, Nav, Button, Container } from 'react-bootstrap';
import Home from './components/Home';
import Login from './components/authorization/Login';
import { logout } from './services/auth';
import Competitors from "./components/competitors/Competitors";
import AddCompetitor from "./components/competitors/AddCompetitor";
import EditCompetitor from "./components/competitors/EditCompetitor";
import Statistic from "./components/competitors/Statistic";
import Entry from "./components/competitors/Entry";

class App extends React.Component {

    render() {
        const jwt = window.localStorage['jwt'];

        if (jwt) {
            return (
                <>
                    <Router>
                        <Navbar expand bg="dark" variant="dark">
                            <Navbar.Brand as={Link} to="/">
                                Home
                            </Navbar.Brand>
                            <Nav>
                                <Nav.Link as={Link} to="/competitors">
                                    Takmicari
                                </Nav.Link>
                                <Button onClick={() => logout()}>Logout</Button>
                            </Nav>
                        </Navbar>
                        <Container style={{ paddingTop: "10px" }}>
                            <Routes>
                                <Route path="/" element={<Home />} />
                                <Route path="/login" element={<Navigate replace to='/' />} />
                                <Route path="/competitors" element={<Competitors />} />
                                <Route path="/competitors/add" element={<AddCompetitor />} />
                                <Route path="/competitors/edit/:id" element={<EditCompetitor />} />
                                <Route path="/competitors/statistic" element={<Statistic />} />
                                <Route path="/entry/newentry/:id" element={<Entry />} />
                                <Route path='*' element={<Navigate replace to='/' />} />
                            </Routes>
                        </Container>
                    </Router>
                </>
            );
        } else {
            return (
                <>
                    <Router>
                        <Navbar expand bg="dark" variant="dark">
                            <Navbar.Brand as={Link} to="/">
                                Home
                            </Navbar.Brand>
                            <Nav>
                                <Nav.Link as={Link} to="/competitors">
                                    Takmicari
                                </Nav.Link>
                                <Nav.Link as={Link} to="/login">
                                    Login
                                </Nav.Link>
                            </Nav>
                        </Navbar>
                        <Container style={{ paddingTop: "10px" }}>
                            <Routes>
                                <Route path="/" element={<Home />} />
                                <Route path="/login" element={<Login />} />
                                <Route path="/competitors" element={<Competitors />} />
                                <Route path='*' element={<Navigate replace to='/' />} />
                            </Routes>
                        </Container>
                    </Router>
                </>);
        }
    }
}

const rootElement = document.getElementById('root');
const root = createRoot(rootElement);

root.render(
    <App />,
);