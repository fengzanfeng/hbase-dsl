package com.nearinfinity.hbase.dsl;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.List;
import java.util.NavigableMap;

/**
 * Family is used to retrieve a family of columns from a single row.
 * 
 * @author Aaron McCurry
 */
public interface Family {
	/**
	 * Gets the value form the given column and converts the byte array for the
	 * column to the given type.
	 * 
	 * @param <U>
	 *            the type specified.
	 * @param qualifier
	 *            the column name.
	 * @param c
	 *            the type specified.
	 * @return the newly converted value.
	 */
	<U> U value(String qualifier, Class<U> c);

	/**
	 * Gets the values (all versions) from a single column and converts the byte
	 * array(s) for the column to the given type.
	 * 
	 * @param <U>
	 *            the type specified.
	 * @param qualifier
	 *            the column name.
	 * @param c
	 *            the type specified.
	 * @return the newly converted value(s) with the keys being the time stamps
	 *         of updates.
	 */
	<U> NavigableMap<Long, U> values(String qualifier, Class<U> c);

	/**
	 * Gets the values (all versions) from a single column and converts the byte
	 * array(s) for the column to the given type.
	 * 
	 * @param <U>
	 *            the type specified.
	 * @param qualifier
	 *            the column name.
	 * @param c
	 *            the type specified.
	 * @return the newly converted value(s) in a List with the values being
	 *         sorted ascending by the time stamps of updates.
	 */
	<U> List<U> valuesAscTimestamp(String qualifier, Class<U> c);

	/**
	 * Gets the values (all versions) from a single column and converts the byte
	 * array(s) for the column to the given type.
	 * 
	 * @param <U>
	 *            the type specified.
	 * @param qualifier
	 *            the column name.
	 * @param c
	 *            the type specified.
	 * @return the newly converted value(s) in a List with the values being
	 *         sorted descending by the time stamps of updates.
	 */
	<U> List<U> valuesDescTimestamp(String qualifier, Class<U> c);
}