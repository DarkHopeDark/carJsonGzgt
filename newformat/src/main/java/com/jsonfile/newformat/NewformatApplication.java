package com.jsonfile.newformat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsonfile.newformat.outputFormat.brands;
import com.jsonfile.newformat.outputFormat.models;
import com.jsonfile.newformat.outputFormat.versions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewformatApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewformatApplication.class, args);

		ObjectMapper inputFile = new ObjectMapper();
		List<brands> Brands = new ArrayList<>(); // a liste to stock brand list on a new format

		try {
			// Read the file in an "inputFormat" object.
			List<inputFormat> myFile = inputFile.readValue(new File("C:/Users/pc/Downloads/car.json"),
					new TypeReference<List<inputFormat>>() {
					});

			// Browsing myFile
			for (int i = 0; i < myFile.size(); i++) {
				// On suppose que le brand n'a pas déja été récupéré auparavant.
				boolean newBrand = true;
				// On parcours la nouvelle liste des "Brands" que l'on veut construire
				for (int b = 0; b < Brands.size(); b++) {

					// On verifie si le "Brand" existe dans la nouvelle liste
					if (myFile.get(i).brand.equals(Brands.get(b).getName())) {

						// Si on rentre dans la condition precedente, alors ce n'est pas un nouveau
						// "Brand"
						newBrand = false;

						// On suppose que c'est un nouveau model
						boolean newModel = true;

						// Si le "Brand" a déja été récupéré on doit parcourir les nouveaux models, et
						// verifier
						// que le model courant de "myFile" n'a pas été lui aussi déja récupéré.

						for (int m = 0; m < Brands.get(b).getModels().size(); m++) {

							if (myFile.get(i).model.equals(Brands.get(b).getModels().get(m).getName())) {

								// Si on rentre dans la condition ça veux dire que le model n'est pas nouveau
								newModel = false;

								// On suppose que c'est une nouvelle version
								boolean newVersion = true;

								// Si le "Model" a déja été récupéré on doit parcourir les nouvelles versions,
								// et verifier
								// que la version courante de "myFile" n'a pas été elle aussi déja récupéré.
								for (int v = 0; v < Brands.get(b).getModels().get(m).getVersions().size(); v++) {

									if (myFile.get(i).version
											.equals(Brands.get(b).getModels().get(m).getVersions().get(v).getName())) {

										// Si on rentre dans la condition ça veux dire que la version n'est pas nouvelle
										newVersion = false;
										break;

									}

								}

								// On verifie si la version n'existe pas dans la nouvelle liste et on l'ajoute
								if (newVersion == true) {

									// On crée un nouvelle version
									versions addVersion = new versions();

									// On set les nouveaux attribus de la nouvelle version
									addVersion.setName(myFile.get(i).version);
									addVersion.setHauteur(myFile.get(i).hauteur);
									addVersion.setLongueur(myFile.get(i).longueur);
									addVersion.setLargeur(myFile.get(i).largeur);

									// on verifie que le poids de la version est spécifié dans le fichier source,
									// sinnon on le set a null
									if (myFile.get(i).getPoidsBrute() != null) {

										addVersion.setPoidsBrute(myFile.get(i).poids_brut);

									}

									// Ajout de la nouvelle version a la liste des version du model
									Brands.get(b).getModels().get(m).getVersions().add(addVersion);
								}
							}

						}

						// On verifie si le model n'existe pas dans la nouvelle liste et on l'ajoute
						if (newModel == true) {
							// On crée un nouvel objet de type model.
							models addModel = new models();

							// On spécifie le attribus du nouveau model a partir du model source
							addModel.setName(myFile.get(i).model);

							// On crée une nouvelle version
							versions addVersion = new versions();

							// On set les nouveaux attribus de la nouvelle version
							addVersion.setName(myFile.get(i).version);
							addVersion.setHauteur(myFile.get(i).hauteur);
							addVersion.setLongueur(myFile.get(i).longueur);
							addVersion.setLargeur(myFile.get(i).largeur);

							// on verifie que le poids de la version est spécifié dans le fichier source,
							// sinnon on le set a null
							if (myFile.get(i).getPoidsBrute() != null) {

								addVersion.setPoidsBrute(myFile.get(i).poids_brut);

							}

							// Ajout de la nouvelle version a la liste des versions du nouveau model
							addModel.setVersions(addVersion);

							// Ajout du nouveau model a la liste des model du nouveau brand
							Brands.get(b).getModels().add(addModel);

						}

					}

				}

				// On verifie que c'est un nouveau "Brand" et on l'ajoute
				if (newBrand == true) {

					// On crée un nouvel objet de type "brands", puis de type "models" puis de type
					// "versions"
					brands addBrand = new brands();
					models addModel = new models();
					versions addVersion = new versions();

					// On prépare la version pour l'ajouter a "addModel"
					addVersion.setName(myFile.get(i).version);
					addVersion.setHauteur(myFile.get(i).hauteur);
					addVersion.setLongueur(myFile.get(i).hauteur);
					addVersion.setLargeur(myFile.get(i).largeur);
					// Certains objet du fichier sources n'ont pas de poids brute, on doit donc
					// vérifier
					if (myFile.get(i).poids_brut != null) {

						addVersion.setPoidsBrute(myFile.get(i).poids_brut);

					}

					// On prépare le model pour l'ajouter a "addBrand"
					addModel.setName(myFile.get(i).model);
					addModel.setVersions(addVersion);

					// On peux maintenant créer l'objet "addBrand"
					addBrand.setName(myFile.get(i).brand);
					addBrand.setModels(addModel);

					// Nous avons maintenant un objet "brand" tout pret, nous pouvons donc l'ajouter
					// a la liste des brand du fichier de sortie
					Brands.add(addBrand);
				}
			}

			System.err.println("All good !!!!!!! time to convert into a jSon file");

			// Convertir la liste des brands en fichier jSon
			inputFile.writeValue(new File("C:/Users/pc/Desktop/newCarFormat.json"), Brands);

			System.err.println("File created go check it !");

		} catch (Exception e) {
			System.err.println("Fuck ! there' a problem, its : \n" + e);
		}
	}

}
