<# macro mkEditor text>
<script src="https://cdn.jsdelivr.net/npm/marked/marked.min.js"></script>
  <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
  <style src="https://github.com/sindresorhus/github-markdown-css/blob/gh-pages/github-markdown.css"></style>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.2.6/ace.js" type="text/javascript" charset="utf-8"></script>
    <body>
        
        <style type="text/css">
            * {
                margin: 0;
                padding: 0;
                outline: none;
                border-radius: 0;
            }
            
            html,
            body {
                width: 100%;
                height: 100%;
                font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
                background-color: #ebebeb;
            }
            #toolbar {
                height: 50px;
                background-color: #444;
                width: 100%;
                color: #fff;
                line-height: 50px;
            }
            #container {
                overflow: auto;
                position: absolute;
                bottom: 0;
                left: 0;
                right: 0;
                top: 50px;
            }
            #editor-column,
            #preview-column {
                width: 49.5%;
                height: 100%;
                overflow: auto;
                position: relative;
                background-color: #fff;
            }
            .pull-left {
                float: left;
            }
            
            .pull-right {
                float: right;
            }
			#mdeditor,#preview,#panel-editor,#panel-preview{
                height: 100%;
                width: 100%;
            }
        </style>
    </head>

    <body>
        <div id='toolbar'>
           <button onclick="insertText('**','**')">加粗</button>
           <button onclick="insertText('_','_')">斜体</button>
           <button onclick="insertText('>')">引用</button>
           
           字体大小
           <select id="fontsize" size="1">
               <option value="10px">10px</option>
               <option value="11px">11px</option>
               <option value="12px" selected="selected">12px</option>
               <option value="13px">13px</option>
               <option value="14px">14px</option>
               <option value="16px">16px</option>
               <option value="18px">18px</option>
               <option value="20px">20px</option>
               <option value="24px">24px</option>
           </select> 
			
       </div>


        <div id="container">
            <div id="editor-column" class="pull-left">
                <div id="mdeditor">
                </div>
            </div>
            <div id="preview-column" class="pull-right">
                <div id="panel-preview">
                </div>
            </div>
        </div>
    </body>
<script>
            var acen_edit = ace.edit('mdeditor'); 
            acen_edit.renderer.setShowPrintMargin(false);
			acen_edit.setOption("wrap", "free"); 
			acen_edit.setOptions({
				enableBasicAutocompletion: true,
				enableSnippets: true,
				enableLiveAutocompletion: true
});			
		   $("#mdeditor").keyup(function() {
                $("#preview-column").html(marked(acen_edit.getValue()));
            });
			
			function insertText(val,val2){
				var text=acen_edit.getCopyText()==''?'':acen_edit.getCopyText();
				val2=val2==undefined?'':val2
				//acen_edit.insert(val+text+val2);
				//修改光标位置
				var o=acen_edit.getCursorPositionScreen();
				//o.column=o.column-val2.length;
				acen_edit.moveCursorToPosition(o);
				
            }
			
           $("#fontsize").change(function() {
               acen_edit.setFontSize($(this).val());
           }) 
      
        </script>
</html>
