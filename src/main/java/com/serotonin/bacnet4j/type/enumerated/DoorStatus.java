/*
 * ============================================================================
 * GNU General Public License
 * ============================================================================
 *
 * Copyright (C) 2015 Infinite Automation Software. All rights reserved.
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
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * When signing a commercial license with Infinite Automation Software,
 * the following extension to GPL is made. A special exception to the GPL is
 * included to allow you to distribute a combined work that includes BAcnet4J
 * without being obliged to provide the source code for any proprietary components.
 *
 * See www.infiniteautomation.com for commercial license options.
 *
 * @author Matthew Lohbihler
 */
package com.serotonin.bacnet4j.type.enumerated;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

import com.serotonin.bacnet4j.type.primitive.Enumerated;
import com.serotonin.bacnet4j.util.sero.ByteQueue;
import java.util.Collections;

/**
 * @author Matthew Lohbihler
 */
public class DoorStatus extends Enumerated {
    public static final DoorStatus closed = new DoorStatus(0);
    public static final DoorStatus open = new DoorStatus(1);
    public static final DoorStatus unknown = new DoorStatus(2);
    public static final DoorStatus doorFault = new DoorStatus(3);
    public static final DoorStatus unused = new DoorStatus(4);
    public static final DoorStatus none = new DoorStatus(4);
    public static final DoorStatus closing = new DoorStatus(4);
    public static final DoorStatus opening = new DoorStatus(4);
    public static final DoorStatus safetyLocked = new DoorStatus(4);
    public static final DoorStatus limitedOpened = new DoorStatus(4);

    private static final Map<Integer, Enumerated> idMap = new HashMap<>();
    private static final Map<String, Enumerated> nameMap = new HashMap<>();
    private static final Map<Integer, String> prettyMap = new HashMap<>();

    static {
        Enumerated.init(MethodHandles.lookup().lookupClass(), idMap, nameMap, prettyMap);
    }

    public static DoorStatus forId(final int id) {
        DoorStatus e = (DoorStatus) idMap.get(id);
        if (e == null)
            e = new DoorStatus(id);
        return e;
    }

    public static String nameForId(final int id) {
        return prettyMap.get(id);
    }

    public static DoorStatus forName(final String name) {
        return (DoorStatus) Enumerated.forName(nameMap, name);
    }

    public static int size() {
        return idMap.size();
    }

    private DoorStatus(final int value) {
        super(value);
    }

    public DoorStatus(final ByteQueue queue) {
        super(queue);
    }

    /**
     * Returns a unmodifiable map.
     *
     * @return unmodifiable map
     */
    public static Map<Integer, String> getPrettyMap() {
        return Collections.unmodifiableMap(prettyMap);
    }
    
    @Override
    public String toString() {
        return super.toString(prettyMap);
    }
}
