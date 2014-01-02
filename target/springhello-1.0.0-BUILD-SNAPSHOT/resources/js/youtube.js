      // 2. Asynchronously load the Upload Widget and Player API code.
      var tag = document.createElement('script');
      tag.src = "https://www.youtube.com/iframe_api";
      var firstScriptTag = document.getElementsByTagName('script')[0];
      firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

      // 3. Define global variables for the widget and the player.
      //    The function loads the widget after the JavaScript code
      //    has downloaded and defines event handlers for callback
      //    notifications related to the widget.
      var widget;
      var player;
      function onYouTubeIframeAPIReady() {
        widget = new YT.UploadWidget('widget', {
          width: 500,
          events: {
            'onUploadSuccess': onUploadSuccess,
            'onProcessingComplete': onProcessingComplete
          }
        });
      }

      // 4. This function is called when a video has been successfully uploaded.
      function onUploadSuccess(event) {
    	  var message ="Your Video is currently being uploaded, please wait for it to appear in this line...!!! In the mean time if you're so restless you can record another one ;)";
         alert('Video ID ' + event.data.videoId + ' was uploaded and is currently being processed.');
    	 $('#sayHello').text(message);
      }

      // 5. This function is called when a video has been successfully
      //    processed.
      function onProcessingComplete(event) {
    	  
    	  insertVideo(event.data.videoId);
    	  
    	  player = new YT.Player('player', {
          height: 290,
          width: 400,
          videoId: event.data.videoId,
          events: {}
        });
      }
    