package customer.customer.controller;

import customer.customer.model.AdressModel;
import customer.customer.model.CustomerModel;
import customer.customer.service.CustomerService;
import spark.Request;
import spark.Response;
import spark.Route;
import static spark.Spark.*;

import com.google.gson.Gson;

public class CustomerController {

	public CustomerController(final CustomerService service) {

		get("/customer/listar", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				try {
					Gson gson = new Gson();
					return gson.toJson(service.listarTodos());
				} catch (Exception e) {
					return e.getMessage();
				}

			}
		});

		get("/customer/listaid/:id", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				try {
					String id = request.params(":id");
					Gson gson = new Gson();
					return gson.toJson(service.listarPorID(Integer.parseInt(id)));
				} catch (Exception e) {
					return e.getMessage();
				}

			}
		});

		post("/customer/inserir", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				try {
					String json = request.body();
					CustomerModel customer = new Gson().fromJson(request.body(), CustomerModel.class);
					service.inserirCustomer(customer);
					return "Customer criado com sucesso";
				} catch (Exception e) {
					return e.getMessage();
				}
				
				
				

			}
		});

		put("/customer/alterar", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				try {
					CustomerModel model = new Gson().fromJson(request.body(), CustomerModel.class);
					service.atualizarCustomer(model);
					return "alterado com sucesso";
				} catch (Exception e) {
					return e.getMessage();
				}
				
				
			

			}
		});

		delete("/customer/deletar/:id", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				try {
					
					String id = request.params(":id");
					service.deletarCustomer(Integer.parseInt(id));
					return "deletado com sucesso";
				} catch (Exception e) {
					return e.getMessage();
				}

				
			}
		});

	}
}
