/*******************************************************************************
 * Instafilter, a RESTful API for manipulating images and applying customizable filters in real-time.
 * 
 * Copyright (C) 2012  Marco Palladino
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package filters.effects;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.jhlabs.image.BlockFilter;

import filters.BaseFilter;
import filters.FilterOption;
import filters.FilterOptions;

public class MosaicFilter extends BaseFilter {

	@Override
	protected void doFilter(BufferedImage image, OutputStream output,
			FilterOptions options, String format) throws IOException {
		
		int size = options.get(FilterOption.SIZE, Integer.class);
		
		BufferedImage outputImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		BlockFilter blockFilter = new BlockFilter();
		blockFilter.setBlockSize(size);
		
		blockFilter.filter(image, outputImage);
		
		ImageIO.write(outputImage, format, output);
	}

}
