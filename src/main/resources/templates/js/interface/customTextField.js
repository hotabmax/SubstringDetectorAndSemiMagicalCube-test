import React,{useState} from "react";
import {Button, TextField, FormControl, InputLabel} from "@mui/material";

export function CustomTextField({inputData, setInputData, arrayOfNumbers}){

    const handleChange = (event) => {
        if (parseInt(event.target.value / 10) === 0
            && parseInt(event.target.value) !== 0){
            let count = 0;
            for(let i = 0; i < arrayOfNumbers.length; i++){
                if (event.target.value === arrayOfNumbers[i]
                    && arrayOfNumbers[i] !== '') count++
            }
            if (count < 1){
                setInputData(event.target.value)
            }
        }
    };

    return <TextField
        onInput={handleChange}
        value={inputData}
        variant="outlined"
        style={{margin: '5px', width: '50px'}}
        inputProps={{style:{textAlign: "center"}}}
    />;
}