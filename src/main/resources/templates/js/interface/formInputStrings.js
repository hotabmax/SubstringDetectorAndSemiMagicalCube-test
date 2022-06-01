import {Button, TextField, FormControl, InputLabel, Select} from "@mui/material";
import React, {useEffect, useState} from "react";
import axios from "axios";

export function FormInputStrings(){
    const [historyFromDataBase, setHistoryFromDataBase]
        = useState([{inputsubstrings: '-', inputstrings:'-'}])
    const [historyFromTXT, setHistoryFromTXT]
        = useState([{inputsubstrings: '-', inputstrings:'-'}])
    const [selectedSubstringsDataBase, setSelectedSubstringsDataBase] = useState()
    const [selectedStringsDataBase, setSelectedStringsDataBase] = useState()
    const [selectedSubstringsTXT, setSelectedSubstringsTXT] = useState()
    const [selectedStringsTXT, setSelectedStringsTXT] = useState()
    const [inputSubstring, setInputSubstring] = useState()
    const [inputString, setInputString] = useState()
    const [result, setResult] = useState()

    let arrayOfStrings = [inputSubstring, inputString]

    useEffect(()=>{
        if(document.readyState){
            axios.post('http://localhost:8080/loadHistoryOfStringsFromDataBase')
                .then(res => {
                    let arr = new Array();
                    arr[0] = {inputsubstrings: '-', inputstrings:'-'};
                    for (let i = 0; i < res.data.length; i++){
                        arr[i+1] = res.data[i]
                    }
                    setHistoryFromDataBase(arr)
                })
            axios.post('http://localhost:8080/loadHistoryOfStringsFromTXT')
                .then(res => {
                    let arr = new Array();
                    arr[0] = {inputsubstrings: '-', inputstrings:'-'};
                    for (let i = 0; i < res.data.length; i++){
                        arr[i+1] = res.data[i]
                    }
                    setHistoryFromTXT(arr)
                })
        }
    })

    function calculate(){
        let request = new Object();
        request.inputsubstrings = inputSubstring
        request.inputstrings = inputString

        let flag = true
        for (let i = 0; i < arrayOfStrings.length; i++){
            if (arrayOfStrings[i] === '' || arrayOfStrings[i] === undefined) flag = false
        }
        if (flag){
            axios.post('http://localhost:8080/playSubstring', request)
                .then(res =>{
                    setResult(res.data)
                })
        }
    }

    function saveInDataBase(){
        if (inputSubstring !== '' && inputString !== ''){
            let request = new Object();
            request.inputsubstrings = inputSubstring
            request.inputstrings = inputString
            axios.post('http://localhost:8080/saveStringsInDataBase', request)
                .then(res =>{
                    axios.post('http://localhost:8080/loadHistoryOfStringsFromDataBase')
                        .then(res => {
                            let arr = new Array();
                            arr[0] = {inputsubstrings: '-', inputstrings:'-'};
                            for (let i = 0; i < res.data.length; i++){
                                arr[i+1] = res.data[i]
                            }
                            setHistoryFromDataBase(arr)
                        })
                })
        }
    }

    function saveInTXT(){
        if (inputSubstring !== '' && inputString !== ''){
            let request = new Object();
            request.inputsubstrings = inputSubstring
            request.inputstrings = inputString
            axios.post('http://localhost:8080/saveHistoryOfStringsInTXT', request)
                .then(res =>{
                    axios.post('http://localhost:8080/loadHistoryOfStringsFromTXT')
                        .then(res => {
                            let arr = new Array();
                            arr[0] = {inputsubstrings: '-', inputstrings:'-'};
                            for (let i = 0; i < res.data.length; i++){
                                arr[i+1] = res.data[i]
                            }
                            setHistoryFromTXT(arr)
                        })
                })
        }

    }


    function setFromDataBase(){
        setInputSubstring(selectedSubstringsDataBase)
        setInputString(selectedStringsDataBase)
    }

    function setFromTXT(){
        setInputSubstring(selectedSubstringsTXT)
        setInputString(selectedStringsTXT)
    }

    function setInput1(event){
        setInputSubstring(event.target.value)
    }

    function setInput2(event){
        setInputString(event.target.value)
    }
    function setSelectSubstringDataBase(event){
        setSelectedSubstringsDataBase(event.target.value)
    }
    function setSelectStringDataBase(event){
        setSelectedStringsDataBase(event.target.value)
    }
    function setSelectSubstringTXT(event){
        setSelectedSubstringsTXT(event.target.value)
    }
    function setSelectStringTXT(event){
        setSelectedStringsTXT(event.target.value)
    }

    return <form>
        <InputLabel
            style={{margin: '5px'}}>
            Введите подстроки
        </InputLabel>
        <TextField
            onInput={setInput1}
            value={inputSubstring}
            variant="outlined"
            style={{margin: '5px', width: '350px'}}
        />
        <InputLabel
            style={{margin: '5px'}}>
            Введите строки в которых нужно искать
        </InputLabel>
        <TextField
            onInput={setInput2}
            value={inputString}
            variant="outlined"
            style={{margin: '5px', width: '350px'}}
        />
        <InputLabel
            style={{margin: '5px'}}>
            {result
            ? <p>Результат: {result}</p>
            : <p>Результат: </p>}
        </InputLabel>
        <Button
            variant="outlined"
            onClick={calculate}
            style={{marginLeft: '120px', marginTop: '5px'}}
        >Посчитать</Button>
        <div><Button
            variant="outlined"
            onClick={saveInDataBase}
            style={{marginLeft: '120px', marginTop: '5px'}}
        >Сохранить</Button></div>
        <div><Button
            onClick={saveInTXT}
            variant="outlined"
            style={{marginLeft: '95px', marginTop: '5px'}}
        >Экспортировать</Button></div>
        <div><Button
            onClick={setFromDataBase}
            variant="outlined"
            style={{marginLeft: '122px'}}
        >Загрузить</Button>
            <select
                onChange={setSelectSubstringDataBase}
                style={{height: '36px', width: '70px', marginTop: '5px'}}
            >{historyFromDataBase.map((data) =>
                <option>{data.inputsubstrings}</option>)}</select>
            <select
                onChange={setSelectStringDataBase}
                style={{height: '36px', width: '70px', marginTop: '5px'}}
            >{historyFromDataBase.map((data) =>
                <option>{data.inputstrings}</option>)}</select>
        </div>
        <div><Button
            onClick={setFromTXT}
            variant="outlined"
            style={{marginLeft: '98px'}}
        >Импортировать</Button>
            <select
                onChange={setSelectSubstringTXT}
                style={{height: '36px', width: '70px', marginTop: '5px'}}
            >{historyFromTXT.map((data) =>
                <option>{data.inputsubstrings}</option>)}</select>
            <select
                onChange={setSelectStringTXT}
                style={{height: '36px', width: '70px', marginTop: '5px'}}
            >{historyFromTXT.map((data) =>
                <option>{data.inputstrings}</option>)}</select>
        </div>
    </form>;
}