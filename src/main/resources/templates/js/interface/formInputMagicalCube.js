import {Button, InputLabel, Table, TableBody, TableRow, TableCell} from "@mui/material";
import React, {useState} from "react";
import axios from "axios";
import {CustomTextField} from "./customTextField";

export function FormInputMagicalCube({historyFromDataBase, setHistoryFromDataBase, historyFromTXT, setHistoryFromTXT}){
    const [selectedHistoryFromDataBase, setSelectedHistoryFromDataBase] = useState()
    const [selectedHistoryFromTXT, setSelectedHistoryFromTXT] = useState()
    const [inputDataN1, setInputDataN1] = useState('')
    const [inputDataN2, setInputDataN2] = useState('')
    const [inputDataN3, setInputDataN3] = useState('')
    const [inputDataN4, setInputDataN4] = useState('')
    const [inputDataN5, setInputDataN5] = useState('')
    const [inputDataN6, setInputDataN6] = useState('')
    const [inputDataN7, setInputDataN7] = useState('')
    const [inputDataN8, setInputDataN8] = useState('')
    const [inputDataN9, setInputDataN9] = useState('')

    let arrayOfNumbers = [inputDataN1, inputDataN2, inputDataN3,
                            inputDataN4, inputDataN5, inputDataN6,
                                inputDataN7, inputDataN8, inputDataN9]

    const [tableData, setTableData] = useState(["-", "-", "-", "-", "-", "-", "-", "-", "-"])

    function calculate(){
        let flag = true
        for (let i = 0; i < arrayOfNumbers.length; i++){
            if (arrayOfNumbers[i] === '') flag = false
        }
        if (flag){
                let arr = new Array();
                arr[0] = inputDataN1;
                arr[1] = inputDataN2;
                arr[2] = inputDataN3;
                arr[3] = inputDataN4;
                arr[4] = inputDataN5;
                arr[5] = inputDataN6;
                arr[6] = inputDataN7;
                arr[7] = inputDataN8;
                arr[8] = inputDataN9;
                axios.post('http://localhost:8080/playSemiMagicalCube', arr)
                    .then(res =>{
                        setTableData([res.data[0], res.data[1], res.data[2],
                            res.data[3], res.data[4], res.data[5],
                            res.data[6], res.data[7], res.data[8]])
                    })
        }
    }
    function saveInDataBase(){
        let flag = true
        for (let i = 0; i < arrayOfNumbers.length; i++){
            if (arrayOfNumbers[i] === '') flag = false
        }
        if(flag){
            let arr = new Array();
            arr[0] = inputDataN1;
            arr[1] = inputDataN2;
            arr[2] = inputDataN3;
            arr[3] = inputDataN4;
            arr[4] = inputDataN5;
            arr[5] = inputDataN6;
            arr[6] = inputDataN7;
            arr[7] = inputDataN8;
            arr[8] = inputDataN9;
            axios.post('http://localhost:8080/saveInputMatrixInDataBase', arr)
                .then(res =>{
                    axios.post('http://localhost:8080/loadHistoryOfInputMatrixFromDataBase')
                        .then(res =>{
                            let arr = new Array();
                            arr[0] = [['-']];
                            for (let i = 0; i < res.data.length; i++){
                                arr[i+1] = res.data[i]
                            }
                            setHistoryFromDataBase(arr)
                        })
                })
        }
    }

    function saveInTXT(){
        let flag = true
        for (let i = 0; i < arrayOfNumbers.length; i++){
            if (arrayOfNumbers[i] === '') flag = false
        }
        if(flag){
            let arr = new Array();
            arr[0] = inputDataN1;
            arr[1] = inputDataN2;
            arr[2] = inputDataN3;
            arr[3] = inputDataN4;
            arr[4] = inputDataN5;
            arr[5] = inputDataN6;
            arr[6] = inputDataN7;
            arr[7] = inputDataN8;
            arr[8] = inputDataN9;
            axios.post('http://localhost:8080/saveInputMatrixInTXT', arr)
                .then(res =>{
                    axios.post('http://localhost:8080/loadHistoryOfInputMatrixFromTXT')
                        .then(res =>{
                            let arr = new Array();
                            arr[0] = [['-']];
                            for (let i = 0; i < res.data.length; i++){
                                arr[i+1] = res.data[i]
                            }
                            setHistoryFromTXT(arr)
                        })
                })
        }

    }

    function setFromDataBase(){
        setInputDataN1(parseInt(selectedHistoryFromDataBase / 100000000))
        setInputDataN2(parseInt(selectedHistoryFromDataBase % 100000000 / 10000000))
        setInputDataN3(parseInt(selectedHistoryFromDataBase % 10000000 / 1000000))
        setInputDataN4(parseInt(selectedHistoryFromDataBase % 1000000 / 100000))
        setInputDataN5(parseInt(selectedHistoryFromDataBase % 100000 / 10000))
        setInputDataN6(parseInt(selectedHistoryFromDataBase % 10000 / 1000))
        setInputDataN7(parseInt(selectedHistoryFromDataBase % 1000 / 100))
        setInputDataN8(parseInt(selectedHistoryFromDataBase % 100 / 10))
        setInputDataN9(parseInt(selectedHistoryFromDataBase % 10))
    }

    function setFromTXT(){
        console.log("123")
        setInputDataN1(parseInt(selectedHistoryFromTXT / 100000000))
        setInputDataN2(parseInt(selectedHistoryFromTXT % 100000000 / 10000000))
        setInputDataN3(parseInt(selectedHistoryFromTXT % 10000000 / 1000000))
        setInputDataN4(parseInt(selectedHistoryFromTXT % 1000000 / 100000))
        setInputDataN5(parseInt(selectedHistoryFromTXT % 100000 / 10000))
        setInputDataN6(parseInt(selectedHistoryFromTXT % 10000 / 1000))
        setInputDataN7(parseInt(selectedHistoryFromTXT % 1000 / 100))
        setInputDataN8(parseInt(selectedHistoryFromTXT % 100 / 10))
        setInputDataN9(parseInt(selectedHistoryFromTXT % 10))
    }

    function setSelectDataBase(event){
        setSelectedHistoryFromDataBase(event.target.value)
    }

    function setSelectTXT(event){
        setSelectedHistoryFromTXT(event.target.value)
    }

    return <form>
        <InputLabel
            style={{margin: '5px'}}>
            Введите матрицу уникальных чисел от 1 до 9
        </InputLabel>
        <div style={{marginLeft: '89px'}}>
            <CustomTextField
                inputData={inputDataN1}
                setInputData={setInputDataN1}
                arrayOfNumbers={arrayOfNumbers}
                inputName={"number1"}
            />
            <CustomTextField
                inputData={inputDataN2}
                setInputData={setInputDataN2}
                arrayOfNumbers={arrayOfNumbers}
                inputName={"number2"}
            />
            <CustomTextField
                inputData={inputDataN3}
                setInputData={setInputDataN3}
                arrayOfNumbers={arrayOfNumbers}
                inputName={"number3"}
            /></div>
        <div style={{marginLeft: '89px'}}>
            <CustomTextField
                inputData={inputDataN4}
                setInputData={setInputDataN4}
                arrayOfNumbers={arrayOfNumbers}
                inputName={"number4"}
            />
            <CustomTextField
                inputData={inputDataN5}
                setInputData={setInputDataN5}
                arrayOfNumbers={arrayOfNumbers}
                inputName={"number5"}
            />
            <CustomTextField
                inputData={inputDataN6}
                setInputData={setInputDataN6}
                arrayOfNumbers={arrayOfNumbers}
                inputName={"number6"}
            /></div>
        <div style={{marginLeft: '89px'}}>
            <CustomTextField
                inputData={inputDataN7}
                setInputData={setInputDataN7}
                arrayOfNumbers={arrayOfNumbers}
                inputName={"number7"}
            />
            <CustomTextField
                inputData={inputDataN8}
                setInputData={setInputDataN8}
                arrayOfNumbers={arrayOfNumbers}
                inputName={"number8"}
            />
            <CustomTextField
                inputData={inputDataN9}
                setInputData={setInputDataN9}
                arrayOfNumbers={arrayOfNumbers}
                inputName={"number9"}
            /></div>
        <InputLabel
            style={{margin: '5px'}}>
            Результат:
        </InputLabel>
        <Table style={{width: '180px', marginLeft:'89px'}}>
            <TableBody>
                <TableRow>
                    <TableCell style ={{textAlign: 'center'}}>{tableData[0]}</TableCell>
                    <TableCell style ={{textAlign: 'center'}}>{tableData[1]}</TableCell>
                    <TableCell style ={{textAlign: 'center'}}>{tableData[2]}</TableCell>
                </TableRow>
                <TableRow>
                    <TableCell style ={{textAlign: 'center'}}>{tableData[3]}</TableCell>
                    <TableCell style ={{textAlign: 'center'}}>{tableData[4]}</TableCell>
                    <TableCell style ={{textAlign: 'center'}}>{tableData[5]}</TableCell>
                </TableRow>
                <TableRow>
                    <TableCell style ={{textAlign: 'center'}}>{tableData[6]}</TableCell>
                    <TableCell style ={{textAlign: 'center'}}>{tableData[7]}</TableCell>
                    <TableCell style ={{textAlign: 'center'}}>{tableData[8]}</TableCell>
                </TableRow>
            </TableBody>
        </Table>
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
            variant="outlined"
            onClick={saveInTXT}
            style={{marginLeft: '95px', marginTop: '5px'}}
        >Экспортировать</Button></div>
        <div><Button
            variant="outlined"
            onClick={setFromDataBase}
            style={{marginLeft: '122px'}}
        >Загрузить</Button>
            <select
                id='selectForUpdate'
                onChange={setSelectDataBase}
                style={{height: '36px', width: '100px',
                        marginTop: '5px', textAlign: 'center'}}
            >{historyFromDataBase.map((arr) =>
                <option>{arr.map((num)=> num)}</option>)}</select></div>
        <div><Button
            variant="outlined"
            onClick={setFromTXT}
            style={{marginLeft: '98px'}}
        >Импортировать</Button>
            <select
                id='selectForUpdate'
                onChange={setSelectTXT}
                style={{height: '36px', width: '100px',
                    marginTop: '5px', textAlign: 'center'}}
            >{historyFromTXT.map((arr) =>
                <option>{arr.map((num)=> num)}</option>)}</select></div>
    </form>;
}