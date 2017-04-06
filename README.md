[ ![Download](https://api.bintray.com/packages/rverbio/feedback/android-sdk/images/download.svg) ](https://bintray.com/rverbio/feedback/android-sdk/_latestVersion)

Rverbio Android SDK
-------------------

The Rverbio Android SDK enables you to get feedback from your customers with as few as 2 lines of code.

**Features**

Rverbio offers some important customization features, with more to come. If you have requests for other features, never hesitate to contact us at <support@rverb.io>.

* Enable/Disable screenshot by default  
* Add custom data to feedback on the back-end
* Supply user identifiers such as an account ID so you can link a user across channels

**Prerequisites**

Before you can use Rverbio in your app, you must create an account at https://rverb.io, and generate an API Key by adding an application.

**Installation**

In your module's gradle.config, add the following line to your dependencies:
    
    compile 'io.rverb:feedback:0.3.4-alpha'

In your AndroidManifest.xml, add this within the <application> block:

    <meta-data android:name="io.rverb.apiKey" android:value="replace_this_with_your_API_Key" />

The API Key is the one that you generated when you added an application to your account at https://rverb.io. Please note that each application should have it's own API Key.
   
**Quick Start**

In your custom Application's onCreate method, add this line:

    Rverbio.initialize(this);
    
You are now ready to capture feedback! When you want to start the feedback activity, simply invoke like so:

    Rverbio.getInstance().startFeedbackActivity(this);
    
That's all you need to do -- we'll take care of the rest!

**Overriding the Default Settings**

You can initialize Rverbio with a RverbioOptions object, setting up defaults as you like. In version 1.0 of the SDK, the only default you can set is whether a screenshot is taken when the user initiates a feedback request:

    RverbioOptions options = new RverbioOptions();
    options.setAttachScreenshotEnabled(false);
    
    Rverbio.initialize(this, options);

**Initializing Without a Custom Application**

If you don't have a custom application, you can also initialize Rverbio from the first activity your app launches. There are a couple caveats, though:

* You will want to ensure that it is only initialized once. If it is initialized multiple times, everything will still work, but the "Session Started" logging will be inaccurate, and all data relating to session length and number of visits may be wrong.
* If a user can enter your app through different activities, you will need to ensure that Rverbio is initialized on any of the possible starting activities, but again, you will want to ensure that it is only initialized once.
    
**Custom Data**

At any time, after Rverbio has been initialized, you can pass data to the Rverbio instance in the form of Key/Value Pairs. Whatever data you attach to the instance will get attached to any feedback sent by the user.

For instance: if you tell Rverbio that a user has just purchased your game's latest power-up, and they submit feedback later that session, that data will get sent along with their feedback.

To add a Key/Value Pair, simply call this method on the Rverbio instance:

	Rverbio.getInstance().addContextDataItem("Last In-App Purchase", "Infinite Fuel Power-Up");
	
**End User Data**

Rverbio automatically links all feedback requests from a single user from an app. By default, each device & app will treat a single person as a new user. However, if you have an identifier by which you know the user, such as a UserId, you can add that to the user, and then we will be able to like all feedback requests from a single user, across devices and apps.

To do this, simply call

	Rverbio.getInstance().updateUserIdentifier("{Identifier}");

For instance, if users in your database have a unique identifier that is a GUID, and user John Smith has a UserId of "d964c733-6ed9-4027-90f8-c60bdc2a2e65", you would make this call:

	Rverbio.getInstance().updateUserIdentifier("d964c733-6ed9-4027-90f8-c60bdc2a2e65");

You can also update the user's email address. This will automatically be filled in on the user's first feedback, if not already supplied, as email address is a required field for the user. 

> Note: Email address will not be used to link users, so if your system
> uses email address as a unique identifier, you will want to call
> updateUserIdentifier with the user's email address.

To update the email address, call:

	Rverbio.getInstance().updateUserEmail("user@emaildomain.com");

Finally, you can update both bits of data at once:

	Rverbio.getInstance().updateUserInfo("user@emaildomain.com", "d964c733-6ed9-4027-90f8-c60bdc2a2e65");

**Support**

If you are having issues with the SDK, please let us know.  
* We can always be reached at: <support@rverb.io>.  
* If you discover a bug, we have an Issue Tracker at <https://github.com/rverbio/android-sdk/issues>

**License**

The SDK is licensed under the Apache 2.0 license.