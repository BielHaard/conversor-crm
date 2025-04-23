package com.reino.srm.conversor.service;


import com.reino.srm.conversor.model.Moeda;

import java.util.List;

public interface MoedaService {


    Moeda salvar(Moeda moeda);

    List<Moeda> listar();
}
