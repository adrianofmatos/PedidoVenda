import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.oxenhitech.pedidovenda.model.Categoria;
import com.oxenhitech.pedidovenda.model.Cliente;
import com.oxenhitech.pedidovenda.model.Endereco;
import com.oxenhitech.pedidovenda.model.Grupo;
import com.oxenhitech.pedidovenda.model.Produto;
import com.oxenhitech.pedidovenda.model.TipoPessoa;
import com.oxenhitech.pedidovenda.model.Usuario;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		Cliente cliente = new Cliente();
		cliente.setNome("João das Couves2");
		cliente.setEmail("joao@dascouves.com");
		cliente.setDocumentoReceitaFederal("123.123.123-12");
		cliente.setTipo(TipoPessoa.FISICA);
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua das Aboboras Vermelhas");
		endereco.setNumero("111");
		endereco.setCidade("Uberlândia");
		endereco.setUf("MG");
		endereco.setCep("38400-000");
		endereco.setCliente(cliente);
		
		cliente.getEnderecos().add(endereco);
		
		manager.persist(cliente);
		
		Usuario usuario = new Usuario();
		usuario.setNome("Maria");
		usuario.setEmail("maria@abadia.com");
		usuario.setSenha("123");
				
		Grupo grupo = new Grupo();
		grupo.setNome("Vendedores");
		grupo.setDescricao("Vendedores da empresa");
				
		usuario.getGrupos().add(grupo);
				
		manager.persist(usuario);

		// instanciamos a categoria pai (Bebidas)
		Categoria categoriaPai = new Categoria();
		categoriaPai.setDescricao("Bebidas");
		
		// instanciamos a categoria filha (Refrigerantes)
		Categoria categoriaFilha = new Categoria();
		categoriaFilha.setDescricao("Refrigerantes");
		categoriaFilha.setCategoriaPai(categoriaPai);
		
		// adicionamos a categoria Refrigerantes como filha de Bebidas
		categoriaPai.getSubcategorias().add(categoriaFilha);
		
		// ao persistir a categoria pai (Refrigerantes), a filha (Bebidas) 
		// deve ser persistida também
		manager.persist(categoriaPai);
		
		// instanciamos e persistimos um produto
		Produto produto = new Produto();
		produto.setCategoria(categoriaFilha);
		produto.setNome("Guaraná 2L");
		produto.setQuantidadeEstoque(10);
		produto.setSku("GUA00123");
		produto.setValorUnitario(new BigDecimal(2.21));
		
		manager.persist(produto);

		trx.commit();
	}
	
}