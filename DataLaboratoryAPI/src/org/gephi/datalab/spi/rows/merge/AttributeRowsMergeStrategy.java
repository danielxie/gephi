/*
Copyright 2008-2011 Gephi
Authors : Eduardo Ramos <eduramiba@gmail.com>
Website : http://www.gephi.org

This file is part of Gephi.

DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

Copyright 2011 Gephi Consortium. All rights reserved.

The contents of this file are subject to the terms of either the GNU
General Public License Version 3 only ("GPL") or the Common
Development and Distribution License("CDDL") (collectively, the
"License"). You may not use this file except in compliance with the
License. You can obtain a copy of the License at
http://gephi.org/about/legal/license-notice/
or /cddl-1.0.txt and /gpl-3.0.txt. See the License for the
specific language governing permissions and limitations under the
License.  When distributing the software, include this License Header
Notice in each file and include the License files at
/cddl-1.0.txt and /gpl-3.0.txt. If applicable, add the following below the
License Header, with the fields enclosed by brackets [] replaced by
your own identifying information:
"Portions Copyrighted [year] [name of copyright owner]"

If you wish your version of this file to be governed by only the CDDL
or only the GPL Version 3, indicate your decision by adding
"[Contributor] elects to include this software in this distribution
under the [CDDL or GPL Version 3] license." If you do not indicate a
single choice of license, a recipient has the option to distribute
your version of this file under either the CDDL, the GPL Version 3 or
to extend the choice of license to its licensees as provided above.
However, if you add GPL Version 3 code and therefore, elected the GPL
Version 3 license, then the option applies only if the new code is
made subject to such option by the copyright holder.

Contributor(s):

Portions Copyrighted 2011 Gephi Consortium.
 */
package org.gephi.datalab.spi.rows.merge;

import org.gephi.data.attributes.api.AttributeColumn;
import org.gephi.datalab.spi.Manipulator;
import org.gephi.graph.api.Attributes;

/**
 * <p>Service for defining strategies for merging a column of rows of a table.</p>
 * <p>Has the same interface as a manipulator.</p>
 * <p>When a <code>RowsMergeStrategy</code> is executed it must reduce all values to one that should be returned later when <code>getReducedValue</code> is called</p>
 * @see Manipulator
 * @author Eduardo Ramos <eduramiba@gmail.com>
 */
public interface AttributeRowsMergeStrategy extends Manipulator{

    /**
     * Prepare column and rows for this merge strategy.
     * At least <b>1</b> row will be set up to merge always.
     * @param rows Rows to merge
     * @param selectedRow Main row of the row group to merge
     * @param column Column to merge
     */
    void setup(Attributes[] rows, Attributes selectedRow, AttributeColumn column);
    
    /**
     * This method is always called after the strategy is set up and executed.
     * @return Reduced value from all rows and the column
     */
    Object getReducedValue();
}
