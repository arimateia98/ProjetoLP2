package trackingThings;

import java.util.HashSet;
import java.util.Set;

//Blu ray. Blu ray pode ser de filmes, séries ou shows. Pode ser um apenas ou uma 
//temporada inteira de uma série. Vocês decidiram que não será possível emprestar
//um único blu ray de uma temporada, ou empresta a temporada inteira ou não empresta nada. 
//No blu-ray de uma temporada você deve guardar a coleção de blu-rays que compõem a temporada. 
//Além das informações gerais que todo item tem (descritas anteriormente), todo blu ray deve
//ter uma duração e uma classificação[2]. A coleção de blu rays que representa uma temporada de uma
//série deve manter
//, além da coleção de blu rays, o gênero da série e o número da temporada. Além disso, blu-rays de
//temporada devem saber informar sua duração total. Dois blu rays são iguais se tiverem o mesmo nome.
//Dois blu-rays de temporada são iguais se tiverem o mesmo nome e mesmo número de temporada.

public class BluRayTemporada {
	
	private Set<BluRay> blurays; 
	private int duracaoTotal;
	
	public BluRayTemporada() {
		this.blurays = new HashSet<BluRay>();
	} 
	
	public Set<BluRay> getBlurays() {
		return this.blurays;
	}
	
	public int calculaDuracaoTotal() {

		for (BluRay bluray : this.blurays) {
			this.duracaoTotal += bluray.getDuracao();
		}
		return this.duracaoTotal;
	}
	

}
