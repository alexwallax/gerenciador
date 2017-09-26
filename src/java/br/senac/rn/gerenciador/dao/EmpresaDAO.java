package br.senac.rn.gerenciador.dao;

import br.senac.rn.gerenciador.model.Empresa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EmpresaDAO {
    
    private final static Map<Integer, Empresa> EMPRESA = new HashMap();
    
    static {
        gerarIdEAdciona(new Empresa("Doceria Bela Vista"));
        gerarIdEAdciona(new Empresa("Ferragens Docel"));
        gerarIdEAdciona(new Empresa("Senac"));
        gerarIdEAdciona(new Empresa("Google"));
        gerarIdEAdciona(new Empresa("Facebook"));
        gerarIdEAdciona(new Empresa("Iskisita Atacado"));
        gerarIdEAdciona(new Empresa("Rodante"));
    }
    
    public Collection buscarPorSimilaridade(String nome){
         if(nome == null){
            return EMPRESA.values();
        }
         List<Empresa> similares = new ArrayList();
         for (Empresa empresa : EMPRESA.values()){
             if(empresa.getNome().toLowerCase().contains(nome.toLowerCase())){
                 similares.add(empresa);
             }
         }
         return similares;
    }
    
    public void adiciona(Empresa empresa){
         gerarIdEAdciona(empresa);
    }

    private static void gerarIdEAdciona(Empresa empresa) {
        int id = EMPRESA.size() + 1;
        empresa.setId((int) id);
        EMPRESA.put(id, empresa);
    }
    
}
