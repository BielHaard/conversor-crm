package com.reino.srm.conversor.service;


import com.reino.srm.conversor.model.TaxaCambio;

import java.util.List;

public interface TaxaCambioService {

    TaxaCambio salvar(TaxaCambio taxa);

    List<TaxaCambio> listar();
}
