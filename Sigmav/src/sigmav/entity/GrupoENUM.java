/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.entity;

/**
 *
 * @author fernando
 */
public enum GrupoENUM {
    
    INVALIDO("Inválido"),
    MOTOR("Motor"),
    CAMBIO("Cambio"),
    DIFERENCIAL("Diferencial"),
    TRANSMISSAO("Transmissão"),
    ELETRICA("Elétrica"),
    CARROCERIA("Carroceria"),
    SUSPENSAO("Suspensão"),
    FREIOS("Freios");
    
    private String grupo;
    
    private GrupoENUM(String grupo){
        this.grupo = grupo;
    }

//------------------------------------------------------------------------------
    
    
    public String getGrupo() {
        return this.grupo;
    }
        
    public static String[] getGrupos(){
        String[] grupos = new String[GrupoENUM.values().length];
        
        for(GrupoENUM grupoAux: GrupoENUM.values()){
            grupos[grupoAux.ordinal()] = grupoAux.getGrupo();
        }
        return grupos;
    }
    
    public static GrupoENUM getGrupoEnum(String aux){
        if(aux == "Inválido"){
            return INVALIDO;
        }
        if(aux == "Motor"){
            return MOTOR;
        }
        if(aux == "Cambio"){
            return CAMBIO;
        }
        if(aux == "Diferencial"){
            return DIFERENCIAL;
        }
        if(aux == "Transmissão"){
            return TRANSMISSAO;
        }
        if(aux == "Elétrica"){
            return ELETRICA;
        }
        if(aux == "Carroceria"){
            return CARROCERIA;
        }
        if(aux == "Suspensão"){
            return SUSPENSAO;
        }
        if(aux == "Freios"){
            return FREIOS;
        }
        return null;
    }

//------------------------------------------------------------------------------

    
    @Override
    public String toString() {
        return "Grupo{" + "grupo=" + grupo + '}';
    }


//------------------------------------------------------------------------------


}
