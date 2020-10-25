package customer.customer.controller;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import com.google.gson.Gson;

import customer.customer.model.AdressModel;
import customer.customer.model.CustomerModel;
import customer.customer.service.AdressService;
import spark.Request;
import spark.Response;
import spark.Route;

public class AdressController {

	public AdressController(final AdressService service) {

		get("/adress", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				try {
					Gson gson = new Gson();
					return gson.toJson(service.listarTodos())  ;
				} catch (Exception e) {
					return e.getMessage();
				}

			}
		});

		get("/adress/:id", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				try {
					Gson gson = new Gson();
					String id = request.params(":id");
					return gson.toJson(service.listarPorID(Integer.parseInt(id)));
				} catch (Exception e) {
					return e.getMessage();
				}

			}
		});

		post("/adress", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				try {
					AdressModel model = new Gson().fromJson(request.body(), AdressModel.class);
					service.inserirAdress(model);
					return "cadastrado com sucesso";
				} catch (Exception e) {
					return e.getMessage();
				}

			}
		});

		put("/adress", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				try {
					AdressModel model = new Gson().fromJson(request.body(), AdressModel.class);
					service.atualizarAdress(model);
					return "alterado com sucesso";
				} catch (Exception e) {
					return e.getMessage();
				}

			}
		});

		delete("/adress/:id", new Route() {
			@Override
			public Object handle(Request request, Response response) {
				try {
					String id = request.params(":id");
					service.deletarAdress(Integer.parseInt(id));
					return "deletado com sucesso";
				} catch (Exception e) {
					return e.getMessage();
				}

			}
		});

	}

}
