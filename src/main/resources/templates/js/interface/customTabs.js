import React, {useState} from "react";
import {Box, Tab} from "@mui/material"
import {TabPanel, TabContext, TabList} from "@mui/lab";
import {FormInputStrings} from "./formInputStrings";
import {FormInputMagicalCube} from "./formInputMagicalCube";
import axios from "axios";

export function CustomTabs(){
    const [value, setValue] = useState('1');
    const handleChange = (event, newValue) => {
        setValue(newValue);
    };

    const [historyFromDataBase, setHistoryFromDataBase] = useState([["-"]])
    const [historyFromTXT, setHistoryFromTXT] = useState([["-"]])

    function click(){
        axios.post('http://localhost:8080/loadHistoryOfInputMatrixFromDataBase')
            .then(res =>{
                if(res.data.length !== 0){
                    let arr = new Array();
                    arr[0] = [['-']];
                    for (let i = 0; i < res.data.length; i++){
                        arr[i+1] = res.data[i]
                    }
                    setHistoryFromDataBase(arr)
                }
            })
        axios.post('http://localhost:8080/loadHistoryOfInputMatrixFromTXT')
            .then(res =>{
                if(res.data.length !== 0){
                    let arr = new Array();
                    arr[0] = [['-']];
                    for (let i = 0; i < res.data.length; i++){
                        arr[i+1] = res.data[i]
                    }
                    setHistoryFromTXT(arr)
                }
            })
    }

    return <Box sx={{margin: 'auto', width: '500px', typography: 'body1' }}>
        <TabContext value={value}>
            <Box>
                <TabList onChange={handleChange} aria-label="lab API tabs example">
                    <Tab label="Нахождение подстрок" value="1" />
                    <Tab onClick={click} label="Полумагический квадрат" value="2" />
                </TabList>
            </Box>
            <TabPanel value="1"><FormInputStrings/></TabPanel>
            <TabPanel value="2">
                <FormInputMagicalCube
                    historyFromDataBase={historyFromDataBase}
                    setHistoryFromDataBase={setHistoryFromDataBase}
                    historyFromTXT={historyFromTXT}
                    setHistoryFromTXT={setHistoryFromTXT}
                /></TabPanel>
        </TabContext>
    </Box>;
}