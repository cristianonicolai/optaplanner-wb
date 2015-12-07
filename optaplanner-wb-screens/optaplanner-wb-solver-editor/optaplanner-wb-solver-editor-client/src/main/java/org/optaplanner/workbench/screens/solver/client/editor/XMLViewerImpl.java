/*
 * Copyright 2015 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.optaplanner.workbench.screens.solver.client.editor;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RequiresResize;
import org.uberfire.ext.widgets.common.client.ace.AceEditor;
import org.uberfire.ext.widgets.common.client.ace.AceEditorMode;
import org.uberfire.ext.widgets.common.client.ace.AceEditorTheme;

public class XMLViewerImpl
        extends Composite
        implements XMLViewer,
                   RequiresResize {

    private final AceEditor editor = new AceEditor();

    public XMLViewerImpl() {
        editor.startEditor();
        editor.setMode( AceEditorMode.XML );
        editor.setTheme( AceEditorTheme.CHROME );
        editor.setReadOnly( true );
        initWidget( editor );
    }

    @Override
    public void onResize() {
        int height = getParent().getOffsetHeight();
        int width = getParent().getOffsetWidth();
        setPixelSize( width,
                      height );
        editor.setHeight( height + "px" );
        editor.redisplay();
    }

    @Override
    public void setContent( String content ) {
        editor.setText( content );
    }

    public void clear() {
        editor.setText( null );
    }

    private int ensureValidMeasure( int value ) {
        if ( value < 0 ) {
            return 0;
        } else {
            return value;
        }
    }
}