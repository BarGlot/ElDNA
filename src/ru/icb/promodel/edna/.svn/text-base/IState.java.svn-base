///////////////////////////////////////////////////////////////////////////////
//Copyright (C) 1999-2009 Anatoly Sorokin
//
//This library is free software; you can redistribute it and/or
//modify it under the terms of the GNU Lesser General Public
//License as published by the Free Software Foundation; either
//version 2.1 of the License, or (at your option) any later version.
//
//This library is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU Lesser General Public License for more details.
//
//You should have received a copy of the GNU Lesser General Public
//License along with this program; if not, write to the Free Software
//Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
//---------------------------------------------------------------------------
//Этот класс является частью библиотеки eDNA.
//
//Авторские права на эту библиотеку принадлежат Анатолию Сорокину
//Все права защищены
//////////////////////////////////////////////////////////////////////////////
package ru.icb.promodel.edna;

import java.util.List;

/**
 * Интерфейс для класса реализующего как шаблон, так и конкретную реализацию
 * состояния ДНК при движении билдера вдоль первичной послдовательности.
 * 
 * @author asorokin
 * 
 */
public interface IState {

	/**
	 * Возвращает имя состояния. Для ДНК это одно из A,T,G,C.
	 * 
	 * @return
	 */
	String getName();

	/**
	 * Возвращает положение стейта по оси z.
	 * 
	 * @return
	 */
	double getPosition();

	/**
	 * Задает новое положение стейту.
	 * 
	 * @param z
	 */
	void setPosition(double z);

	/**
	 * Возвращает ширину шаблона в ангстремах.
	 * 
	 * @return
	 */
	int getWidth();

	/**
	 * Возвращает шаблон. Длина массива должна совпадать с шириной, возвращаемой
	 * {@link #getWidth}.
	 * 
	 * @return
	 */
	double[] getTemplate();

	/**
	 * Обновляет значение профиля потенциала. Использует заданный шаблон, чтобы
	 * обновить профиль и координаты элементов профиля.
	 * 
	 * @param p
	 *            массив значений профиля, который надо обновить
	 * @param z
	 *            массив значений координат, который надо обновить
	 */
	void updateProfile(List<Double> p, List<Integer> z);
}
