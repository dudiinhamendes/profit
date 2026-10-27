package br.com.sistema.profit.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

public interface CrudController<T> {

	public String cadastrar(Model model);

	public String visualizar(@RequestParam Long id, Model model);

	public String editar(@RequestParam Long id, Model model);

	public String listar(Model model);

	public String salvar(@ModelAttribute T t);
}
