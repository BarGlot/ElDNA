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

/**
 * Класс осуществляющий сбор и аггрегацию электростатического профиля. Основной
 * задачей данного класса является построение профиля по заданному набору
 * шаблонов.
 * 
 * @author asorokin
 * 
 */
public interface ICollector {
	/**
	 * Добавляет стейт.
	 * 
	 * @param s
	 */
	void add(IState s);

	/**
	 * Выставляет начало отсчета в цент конкретного нуклеотида. Выбранный
	 * нуклеотид должен быть уже добавлен в список обработанных стейтов. По
	 * умолчанию, начало отсчета расположенно в центре первого (нулевого)
	 * нуклеотида.
	 * 
	 * @param o
	 *            пололжение начала отсчета координат по оси z в
	 *            последовательности.
	 * @throws IllegalStateException
	 *             в случае если нуклеотид не был добавлен.
	 * @throws IllegalArgumentException
	 *             в случае если аргумент меньше нуля.
	 */
	void setOrigin(int o) throws IllegalStateException,
			IllegalArgumentException;

	/**
	 * Основной метод. Осуществляет анализ добавленных стейтов и сборку профиля.
	 * 
	 * @throws IllegalStateException
	 *             если длина последовательности недостаточна для обрезки
	 *             фланкеров.
	 */
	void collect() throws IllegalStateException;

	/**
	 * Задает длину обрезки по краям. Для учета краевых эффектов, мы удаляем из
	 * профиля значения, соответствующие концевым фрагментам ДНК определенной
	 * длины (фланкерам). Этот метод объявляет требуемую длину. По умолчанию
	 * удаляется по 100 пар оснований с каждого конца.
	 * 
	 * @param t
	 *            число нуклеодидов, игнорируемых на каждом конце.
	 */
	void setTrim(int t);

	/**
	 * Возвращает длину последовательности. Длина последовательности считается
	 * после удаления фланкеров.
	 * 
	 * @return количество учтенных стейтов.
	 */
	int getSeqLength();

	/**
	 * Возвращает длину профиля в ангстремах. Длина профиля считается после
	 * удаления фланкеров.
	 * 
	 * @return длина профиля в ангстремах.
	 */
	int getProfileWidth();

	/**
	 * Возвращает профиль. Длина массива соответствует значению, возвращаемому
	 * {@link #getProfileWidth()}.
	 * 
	 * @return профиль
	 */
	Double[] getProfile();

	/**
	 * Возвращает координаты для каждого элемента профиля. Длина массива
	 * соответствует значению, возвращаемому {@link #getProfileWidth()}.
	 * 
	 * @return координаты точек профиля
	 */
	Integer[] getZValues();

	/**
	 * Возвращает координаты центров нуклеотидов. Длина массива соответствует
	 * значению, возвращаемому {@link #getSeqLength()}.
	 * 
	 * @return координаты центров нуклеотидов.
	 */
	Double[] getNucCenters();

}
