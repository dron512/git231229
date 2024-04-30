import React, { useState } from 'react';
import { aa } from '../../api/aa/aa';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';

export const AA = () => {

    const [data, setData] = useState("asdnfklcjqwnelrkjewnr");
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    return (
        <div className='container'>
            <h1>구분을</h1>
            <h2>{data}</h2>
            <button className='btn btn-primary p-3' onClick={() => {
                aa(setData);
            }}>버튼</button>


            <div
                className="modal show"
                style={{ display: 'block', position: 'initial' }}
            >
                <Button variant="primary" onClick={handleShow}>
                    Launch demo modal
                </Button>

                <Modal show={show} onHide={handleClose}>
                    <Modal.Header closeButton>
                        <Modal.Title>Modal heading</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>Woohoo, you are reading this text in a modal!</Modal.Body>
                    <Modal.Footer>
                        <Button variant="secondary" onClick={handleClose}>
                            Close
                        </Button>
                        <Button variant="primary" onClick={handleClose}>
                            Save Changes
                        </Button>
                    </Modal.Footer>
                </Modal>
            </div>
        </div>
    )
}

export const AA2 = () => {

    const [data, setData] = useState("asdnfklcjqwnelrkjewnr");
    const [myData, setMyData] = useState("원래Data");

    const sucessDataA = (asdf) => {
        setData(asdf);
    }
    const sucessDataB = (asdf) => {
        setMyData(asdf);
    }

    return (
        <div>
            <h1>구분을</h1>
            <h2>{data}</h2>
            <h2>{myData}</h2>
            <button onClick={() => {
                aa({ sucessDataA, sucessDataB });
            }}>버튼</button>

        </div>
    )
}