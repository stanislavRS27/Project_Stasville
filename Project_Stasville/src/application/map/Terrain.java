package application.map;

import application.actors.Actor;
import application.map.Terrain;

public class Terrain {
	
	//the map has a square-like grid
	private final int MAX_ADJACENT_TERRAINS = 4;
	
	private final String name;
	private Actor[] terrainPopulationSinisters;
	private Actor[] terrainPopulationNobels;
	private Terrain[] adjacentTerrain = new Terrain[MAX_ADJACENT_TERRAINS];
	
	public Terrain(String name) {
		this.name = name;
	}
	
	public Terrain(Terrain terrain) {
		this.name = terrain.name;
		this.terrainPopulationSinisters = terrain.terrainPopulationSinisters;
		this.terrainPopulationNobels = terrain.terrainPopulationNobels;
		this.adjacentTerrain = terrain.adjacentTerrain;
	}
	
	public String getName() {
		return name;
	}
	
	public Actor[] getTerrainPopulationSinisters() {
		return terrainPopulationSinisters;
	}
	
	public Actor[] getTerrainPopulationNobels() {
		return terrainPopulationNobels;
	}
	
	public void setTerrainPopulationSinisters(Actor[] terrainPopulation) {
		this.terrainPopulationSinisters = terrainPopulation;
		for(int i = 0; i < terrainPopulation.length; ++i) {
			if(terrainPopulation[i] != null) {
				terrainPopulation[i].setCurrentTerrain(this);
			}
		}
	}
	
	public void setTerrainPopulationNobels(Actor[] terrainPopulation) {
		this.terrainPopulationNobels = terrainPopulation;
		for(int i = 0; i < terrainPopulation.length; ++i) {
			if(terrainPopulation[i] != null) {
				terrainPopulation[i].setCurrentTerrain(this);
			}
		}
	}
	
	public Terrain[] getAdjacentTerrain() {
		return adjacentTerrain;
	}
	
	public void setAdjacentTerrain(Terrain adjacentTerrain, int possition) {
		this.adjacentTerrain[possition] = adjacentTerrain; 
	}
	
	// TODO Auto-generated method stub
	public static Terrain[] createMap(String[] terrainNamesList, int dimensionX) {
		int mapSize = terrainNamesList.length;
		String[] terrainNames = terrainNamesList;
		String[] temp = new String[mapSize];
		Terrain[] map = new Terrain[mapSize];
		int rand;

		//randomize terrain
		for(int i = 0; i < mapSize; ++i) {
			rand = (int)(Math.random() * (mapSize - i));
			temp[i] = new String(terrainNames[rand]);
				
			int p = 0;
			for(int j = 0; j < mapSize - i; ++j) {
				if(j == rand) {
					continue;
				}
				terrainNames[p] = terrainNames[j];
				p++;
			}
		}
		
		for(int i = 0; i < mapSize; ++i) {
			map[i] = new Terrain(temp[i]);
		}
		
		for(int i = 0; i < mapSize; ++i) {
			//assign left neighbour
			if((((i + 1) % dimensionX) - 1) != 0) {
				map[i].setAdjacentTerrain(map[i - 1], 0);
				if(map[i - 1].getAdjacentTerrain()[1] == null) {
					map[i - 1].setAdjacentTerrain(map[i], 1);
				}
			}
			//assign right neighbour
			if(((i + 1) % dimensionX) != 0) {
				map[i].setAdjacentTerrain(map[i + 1], 1);
				if(map[i + 1].getAdjacentTerrain()[0] == null) {
					map[i + 1].setAdjacentTerrain(map[i], 0);
				}
			}
			//assign up neighbour
			if(i > 2) {
				map[i].setAdjacentTerrain(map[i - dimensionX], 2);
				if(map[i - dimensionX].getAdjacentTerrain()[3] == null) {
					map[i - dimensionX].setAdjacentTerrain(map[i], 3);
				}
			}
			//assign down neighbour
			if(i < 12) {
				map[i].setAdjacentTerrain(map[i + dimensionX], 3);
				if(map[i + dimensionX].getAdjacentTerrain()[2] == null) {
					map[i + dimensionX].setAdjacentTerrain(map[i], 2);
				}
			}
		}
		
		return map;
	}
	
}
