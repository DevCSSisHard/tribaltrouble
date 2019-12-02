package com.oddlabs.tt.resource;

import com.oddlabs.tt.procedural.Landscape;
import java.io.Serializable;

public strictfp interface WorldGenerator extends Serializable {
	WorldInfo generate(int num_players, int initial_unit_count, float random_start_pos);
	Landscape.TerrainType getTerrainType();
	int getMetersPerWorld();
}
