/*
 * This file is part of ViaBackwards - https://github.com/ViaVersion/ViaBackwards
 * Copyright (C) 2016-2022 ViaVersion and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.viaversion.viabackwards.protocol.protocol1_19to1_19_1.packets;

import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.protocol1_19to1_19_1.Protocol1_19To1_19_1;
import com.viaversion.viaversion.api.minecraft.entities.Entity1_19Types;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.type.types.version.Types1_18;
import com.viaversion.viaversion.api.type.types.version.Types1_19;
import com.viaversion.viaversion.protocols.protocol1_19_1to1_19.ClientboundPackets1_19_1;

public final class EntityPackets1_19_1 extends EntityRewriter<Protocol1_19To1_19_1> {

    public EntityPackets1_19_1(final Protocol1_19To1_19_1 protocol) {
        super(protocol);
    }

    @Override
    protected void registerPackets() {
        registerMetadataRewriter(ClientboundPackets1_19_1.ENTITY_METADATA, Types1_19.METADATA_LIST, Types1_18.METADATA_LIST);
        registerRemoveEntities(ClientboundPackets1_19_1.REMOVE_ENTITIES);
        registerSpawnTracker(ClientboundPackets1_19_1.SPAWN_ENTITY);
    }

    @Override
    public void registerRewrites() {
        filter().type(Entity1_19Types.ALLAY).cancel(16); // Dancing
        filter().type(Entity1_19Types.ALLAY).cancel(17); // Can duplicate
    }

    @Override
    public EntityType typeFromId(final int typeId) {
        return Entity1_19Types.getTypeFromId(typeId);
    }

}