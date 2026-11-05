package br.com.sistema.profit.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

public interface CrudController<T> {

	public String cadastrar(Model model);

	public String visualizar(@RequestParam Long id, Model model);

	public String editar(@RequestParam Long id, Model model);

	public String listar(Model model);

	public String salvar(@ModelAttribute T t);
	
	public default void adicionarMensagemErro(Model model, String message) {
		String ELEMENTO_INTERFACE = "mensagemErro";
		String NOME_OBJETO = getClass().getSimpleName().split("Controller")[0];
		if (StringUtils.isNotBlank(message)) {
			switch(message) {
			case "notFound":
				model.addAttribute(ELEMENTO_INTERFACE, NOME_OBJETO + " não encontrado.");
				break;
			default:
				model.addAttribute(ELEMENTO_INTERFACE, NOME_OBJETO + ": " + message);
				break;
			}
		}
	}
	
	public default void adicionarMensagemSucesso(Model model, T objetoNegocio, String message) {
		String ELEMENTO_INTERFACE = "mensagemSucesso";
		String NOME_OBJETO = this.getClass().getSimpleName().split("Controller")[0];
		if (StringUtils.isNotBlank(message)) {
			switch(message) {
			case "saved":
				model.addAttribute(ELEMENTO_INTERFACE, NOME_OBJETO + " salvo com sucesso.");
				break;
			default:
				model.addAttribute(ELEMENTO_INTERFACE, NOME_OBJETO + ": " + message);
				break;
			}
		}
	}
}
