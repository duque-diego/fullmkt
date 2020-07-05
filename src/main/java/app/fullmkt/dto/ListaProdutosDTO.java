package app.fullmkt.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by diegods on 28/05/18.
 */

public class ListaProdutosDTO implements Serializable{

    public ListaProdutosDTO(List<ProdutoDTO> produtoDTO) {
        this.produtoDTO = produtoDTO;
    }

    private List<ProdutoDTO> produtoDTO;

    public ListaProdutosDTO() {

    }

    public List<ProdutoDTO> getProdutoDTO() {
        return produtoDTO;
    }

    public void setProdutoDTO(List<ProdutoDTO> produtoDTO) {
        this.produtoDTO = produtoDTO;
    }
}
