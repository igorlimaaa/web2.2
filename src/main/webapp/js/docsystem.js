/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validaData() {
    var dataAtual = new Date();
    var dataMarcada = new Date(document.getElementById('data').value);

    if (dataMarcada < dataAtual) {
        alert('A consulta deve ser marcada para um dia posterior ao dia atual.');
        return false;
    }

    return true;

}

