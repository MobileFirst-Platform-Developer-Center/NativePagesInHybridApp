/**
 * COPYRIGHT LICENSE: This information contains sample code provided in source code form. You may copy, modify, and distribute
 * these sample programs in any form without payment to IBM® for the purposes of developing, using, marketing or distributing
 * application programs conforming to the application programming interface for the operating platform for which the sample code is written.
 * Notwithstanding anything to the contrary, IBM PROVIDES THE SAMPLE SOURCE CODE ON AN "AS IS" BASIS AND IBM DISCLAIMS ALL WARRANTIES,
 * EXPRESS OR IMPLIED, INCLUDING, BUT NOT LIMITED TO, ANY IMPLIED WARRANTIES OR CONDITIONS OF MERCHANTABILITY, SATISFACTORY QUALITY,
 * FITNESS FOR A PARTICULAR PURPOSE, TITLE, AND ANY WARRANTY OR CONDITION OF NON-INFRINGEMENT. IBM SHALL NOT BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL OR CONSEQUENTIAL DAMAGES ARISING OUT OF THE USE OR OPERATION OF THE SAMPLE SOURCE CODE.
 * IBM HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS OR MODIFICATIONS TO THE SAMPLE SOURCE CODE.
 */
//
//  HelloNative.m
//  module081iOSCombiningNativeAndWebPagesIOSShowNativePageIphone
//
//  Created by admin on 11/2/11.
//  Copyright (c) 2011 __MyCompanyName__. All rights reserved.
//

#import "HelloNative.h"
#import "NativePage.h"

@implementation HelloNative

@synthesize nameParam;

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

-(void)setDataFromWebView:(NSDictionary*)data{
    self.nameParam = (NSString*)[data valueForKey:@"nameParam"];
}

-(IBAction)returnClicked:(id)sender{
    NSString *phone = [phoneNumber text];
    NSDictionary *returnedData = [NSDictionary dictionaryWithObject:phone
                                                             forKey:@"phoneNumber"];
    // Return to WebView 
    [NativePage showWebView:returnedData];   
}

-(void)onBeforeShow{}

-(void)onAfterShow{}

- (void)didReceiveMemoryWarning
{
    // Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
    
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - View lifecycle

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
}

-(void) viewWillAppear:(BOOL)animated {
    [nameLabel setText:self.nameParam];    
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    // e.g. self.myOutlet = nil;
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    return YES;
}

@end
