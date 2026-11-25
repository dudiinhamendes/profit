package br.com.sistema.profit.controller;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Interface que define o padrão para controllers de CRUD similares.
 */
public interface CrudController<T> {

	public String cadastrar(Model model);

	public String visualizar(@RequestParam Long id, Model model);

	public String editar(@RequestParam Long id, Model model);

	public String listar(@RequestParam Optional<String> msg, Model model);

	public String salvar(@ModelAttribute T t);
	
	/**
	 * Este método adiciona um erro à interface que o aciona.
	 * 
	 * @param model
	 * @param message Segue o padrão "x-msg", onde "x" é o tipo da mensagem 
	 *  <br>e "msg" é o código a ser usado no switch case.
	 *  <ul><li>e: error</li><li>s: success</li></ul>
	 */
	public default void adicionaMensagem(Model model, String message) {
		String ELEMENTO_INTERFACE = message.split("-")[0].equals("e") ? "mensagemErro" : "mensagemSucesso";
		String NOME_OBJETO = this.getClass().getSimpleName().split("Controller")[0];
		message = message.split("-")[1];
		if (StringUtils.isNotBlank(message)) {
			switch(message) {
			case "notFound":
				model.addAttribute(ELEMENTO_INTERFACE, NOME_OBJETO + " não encontrado.");
				break;
			case "saved":
				model.addAttribute(ELEMENTO_INTERFACE, NOME_OBJETO + " salvo com sucesso.");
				break;
			case "deleted":
				model.addAttribute(ELEMENTO_INTERFACE, NOME_OBJETO + " deletado com sucesso.");
				break;
			case "sameName":
				model.addAttribute(ELEMENTO_INTERFACE, NOME_OBJETO + " com este nome já existe.");
				break;
			case "invalidData":
				model.addAttribute(ELEMENTO_INTERFACE, NOME_OBJETO + " não salvo. Dados inválidos");
				break;
			case "unauthorized":
				model.addAttribute(ELEMENTO_INTERFACE, NOME_OBJETO + " não salvo. Você não tem autorização para isso");
			default:
				model.addAttribute(ELEMENTO_INTERFACE, NOME_OBJETO + ": " + message);
				break;
			}
		}
	}
}
