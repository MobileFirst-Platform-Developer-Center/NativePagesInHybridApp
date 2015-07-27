/*
 * COPYRIGHT LICENSE: This information contains sample code provided in source code form. You may copy, modify, and distribute
 * these sample programs in any form without payment to IBM® for the purposes of developing, using, marketing or distributing
 * application programs conforming to the application programming interface for the operating platform for which the sample code is written.
 * Notwithstanding anything to the contrary, IBM PROVIDES THE SAMPLE SOURCE CODE ON AN "AS IS" BASIS AND IBM DISCLAIMS ALL WARRANTIES,
 * EXPRESS OR IMPLIED, INCLUDING, BUT NOT LIMITED TO, ANY IMPLIED WARRANTIES OR CONDITIONS OF MERCHANTABILITY, SATISFACTORY QUALITY,
 * FITNESS FOR A PARTICULAR PURPOSE, TITLE, AND ANY WARRANTY OR CONDITION OF NON-INFRINGEMENT. IBM SHALL NOT BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL OR CONSEQUENTIAL DAMAGES ARISING OUT OF THE USE OR OPERATION OF THE SAMPLE SOURCE CODE.
 * IBM HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS OR MODIFICATIONS TO THE SAMPLE SOURCE CODE.
 */

using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using Cordova.Extension.Commands;
using Newtonsoft.Json;

namespace NativePagesInHybridApp
{
    public partial class HelloNative : UserControl
    {
        public HelloNative()
        {
            InitializeComponent();
            if (WLNativePage.Data != null)
            {
                Dictionary<string, string> data = JsonConvert.DeserializeObject<Dictionary<string, string>>(WLNativePage.Data);
                NameReceivedTextBlock.Text = "Hello " + data["nameParam"];
                tb_returnValue.Text = "1234567890";
            }
            DoneButton.Click += new RoutedEventHandler(DoneButton_Click); 
        }

        void DoneButton_Click(object sender, RoutedEventArgs e)
        {
            Dictionary<string, string> data = new Dictionary<string, string>
            {
                { "phoneNumber", tb_returnValue.Text }
            };
 
            string json = JsonConvert.SerializeObject(data, Formatting.Indented);
            WLNativePage.backFromNative(this, json);
        }
    }
}
